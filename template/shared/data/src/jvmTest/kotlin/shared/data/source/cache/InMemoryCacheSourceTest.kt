package shared.data.source.cache

import io.ktor.util.collections.ConcurrentSet
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.time.Duration.Companion.seconds

class InMemoryCacheSourceTest {

    private val cache: CacheSource = InMemoryCacheSource()

    @Test
    fun `make sure all cache actions are performed in not blocking way`() = runBlocking {
        val iterations = 1000
        val cached = ConcurrentSet<Int>()
        repeat(iterations) { iteration ->
            GlobalScope.launch {
                cache
                    .get(TestCacheKey(iteration)) {
                        delay(2.seconds)
                        iteration
                    }
                    .value()
                    ?.let(cached::add)
            }
        }
        delay(3.seconds)
        assertEquals(iterations, cached.size)
    }

    @Test
    fun `make sure same actions use the same cached value`() = runBlocking {
        val key = UUIDCacheKey(Int.MAX_VALUE)
        val iterations = 1000
        val cached = ConcurrentSet<UUID>()
        repeat(iterations) {
            launch {
                delay(300)
                cache
                    .get(key) {
                        delay(1.seconds)
                        UUID.randomUUID()
                    }
                    .value()
                    ?.let(cached::add)
            }
        }
        delay(2.seconds)
        assertEquals(1, cached.size)
    }

    @Test
    fun `check cached state logic`() = runBlocking {
        val key = UUIDCacheKey(Int.MAX_VALUE, ttl = 100)
        val entry = cache.get(key) { UUID.randomUUID() }
        val value1 = entry.value()
        val value1Last = entry.last()
        delay(100)
        val value2 = entry.value()
        delay(100)
        assertNotEquals(value1, value2)
        assertEquals(value1, value1Last)
        assertNotEquals(value2, entry.value())
    }

    private data class TestCacheKey(
        val id: Int,
        override val ttl: Long = CacheKey.TTL_UNLIMITED
    ) : CacheKey<Int>

    private data class UUIDCacheKey(
        val id: Int,
        override val ttl: Long = CacheKey.TTL_UNLIMITED
    ) : CacheKey<UUID>

}