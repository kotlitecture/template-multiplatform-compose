package shared.data.source.cache

import co.touchlab.stately.collections.ConcurrentMutableMap
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import shared.data.misc.isCancellationException
import kotlin.jvm.Transient
import kotlin.reflect.KClass

/**
 * Basic implementation of a thread-safe cache for storing and retrieving in-memory data.
 * This source can be utilized as an L1 Cache when managing HTTP requests, offering an efficient means
 * to present data without delays, but with the ability to update based on expiration and other conditions.
 *
 * @param changesRetryInterval The interval, in milliseconds, to retry cache changes.
 * @param exceptionRetryInterval The interval, in milliseconds, to retry cache operations in case of exceptions.
 * @param exceptionRetryCount The maximum number of retries for cache operations in case of exceptions.
 */
@Suppress("UNCHECKED_CAST")
open class InMemoryCacheSource(
    private val changesRetryInterval: Long = 1000L,
    private val exceptionRetryInterval: Long = 3000L,
    private val exceptionRetryCount: Int = 10
) : CacheSource {

    private val dispatcher = Dispatchers.Default
    private val jobs = ConcurrentMutableMap<CacheKeySnapshot, Deferred<*>>()
    private val cache = ConcurrentMutableMap<CacheKeySnapshot, CacheData>()

    override fun <T> get(key: CacheKey<T>, valueProvider: suspend () -> T?): CacheEntry<T> =
        CacheStateImpl(key, valueProvider)

    override fun <T> put(key: CacheKey<T>, value: T) {
        val cacheKey = CacheKeySnapshot(key)
        cache[cacheKey] = CacheData(value)
    }

    override fun clear() {
        jobs.onEach { job -> job.value.cancel() }
        jobs.clear()
        cache.clear()
    }

    override fun <K : CacheKey<*>> invalidate(type: KClass<K>) {
        val jobsIterator = jobs.iterator()
        while (jobsIterator.hasNext()) {
            val entry = jobsIterator.next()
            val key = entry.key
            if (key.type == type) {
                jobsIterator.remove()
                entry.value.cancel()
            }
        }
        val cacheIterator = cache.iterator()
        while (cacheIterator.hasNext()) {
            val entry = cacheIterator.next()
            if (entry.key.type == type) {
                entry.value.invalidate()
            }
        }
    }

    override fun <K : CacheKey<*>> invalidate(key: K) {
        val cacheKey = CacheKeySnapshot(key)
        jobs.remove(cacheKey)?.cancel()
        cache[cacheKey]?.invalidate()
    }

    override fun <K : CacheKey<*>> remove(type: KClass<K>) {
        val jobsIterator = jobs.iterator()
        while (jobsIterator.hasNext()) {
            val entry = jobsIterator.next()
            val key = entry.key
            if (key.type == type) {
                jobsIterator.remove()
                entry.value.cancel()
            }
        }
        val cacheIterator = cache.iterator()
        while (cacheIterator.hasNext()) {
            val entry = cacheIterator.next()
            if (entry.key.type == type) {
                cacheIterator.remove()
                entry.value.invalidate()
            }
        }
    }

    override fun <K : CacheKey<*>> remove(key: K) {
        val cacheKey = CacheKeySnapshot(key)
        jobs.remove(cacheKey)?.cancel()
        cache.remove(cacheKey)
    }

    private suspend fun <T> getValue(
        cacheKey: CacheKeySnapshot,
        valueProvider: suspend () -> T?
    ): T? {
        val job = jobs[cacheKey]
            ?.let { deferredJob ->
                if (deferredJob.isCancelled) {
                    jobs.remove(cacheKey)?.cancel()
                    null
                } else {
                    deferredJob
                }
            }
            ?: run {
                if (cacheKey.key.immortal()) {
                    jobs.computeIfAbsent(cacheKey) {
                        GlobalScope.async { valueProvider() }
                    }
                } else {
                    withContext(dispatcher) {
                        jobs.computeIfAbsent(cacheKey) {
                            async { valueProvider() }
                        }
                    }
                }
            }
        job.invokeOnCompletion { jobs.remove(cacheKey)?.key }

        return job.await() as? T
    }

    private data class CacheData(
        val data: Any?,
        val createTime: Long = Clock.System.now().toEpochMilliseconds()
    ) {

        @Transient
        private var invalid: Boolean = false

        fun isValid(ttl: Long): Boolean = when {
            invalid -> false
            data == null -> false
            ttl > 0 -> !isExpired(ttl)
            ttl == 0L -> false
            else -> true
        }

        fun isExpired(ttl: Long): Boolean {
            val now = Clock.System.now().toEpochMilliseconds()
            return ttl > 0 && createTime + ttl <= now
        }

        fun invalidate() {
            invalid = true
        }
    }

    private inner class CacheStateImpl<T>(
        override val key: CacheKey<T>,
        private val valueProvider: suspend () -> T?
    ) : CacheEntry<T> {

        private val cacheKey = CacheKeySnapshot(key)

        override suspend fun fresh(): T? = cache[cacheKey]?.invalidate().run { value() }
        override suspend fun last(): T? = cache[cacheKey]?.data as? T

        override suspend fun value(): T? {
            val cacheKey = CacheKeySnapshot(key)
            val cacheItem = cache[cacheKey]
            if (cacheItem == null || !cacheItem.isValid(key.ttl)) {
                val data = getValue(cacheKey, valueProvider) ?: return null
                cache[cacheKey] = CacheData(data)
                return data
            } else {
                return cacheItem.data as T?
            }
        }

        override suspend fun changes(): Flow<T> = flow<T> {
            getLastData()?.data
                ?.let { data -> data as? T }
                ?.let { data -> emit(data) }

            var retryAttempt = 0
            while (currentCoroutineContext().isActive) {
                try {
                    val prev = getLastData()
                    val next = value()

                    if (next != null) {
                        emit(next)
                    }

                    if (prev?.data != next) {
                        delay(key.ttl)
                    } else if (prev != null) {
                        val now = Clock.System.now().toEpochMilliseconds()
                        val time = key.ttl - (now - prev.createTime)
                        delay(time)
                    }

                    retryAttempt = 0
                } catch (e: Exception) {
                    retryAttempt++
                    when {
                        retryAttempt >= exceptionRetryCount -> throw e
                        else -> Unit
                    }
                }
            }
        }.distinctUntilChanged().retry { th ->
            !th.isCancellationException().also {
                delay(changesRetryInterval)
            }
        }

        private fun getLastData(): CacheData? = cache[cacheKey]
    }

    private data class CacheKeySnapshot(
        val key: CacheKey<*>,
        val type: KClass<*> = key::class
    )

}