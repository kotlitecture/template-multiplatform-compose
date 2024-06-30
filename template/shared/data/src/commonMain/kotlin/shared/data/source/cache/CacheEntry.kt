package shared.data.source.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Represents the state of a cache entry.
 *
 * @param T The type of the cached value.
 */
interface CacheEntry<T> {

    /** The key associated with this cache entry. */
    val key: CacheKey<T>

    /**
     * Retrieves the cached value.
     *
     * @return The cached value, or new one if the value is not present in the cache or expired.
     */
    suspend fun value(): T?

    /**
     * Retrieves the last cached value.
     *
     * @return The last cached value, or null if the value is not present in the cache.
     */
    suspend fun last(): T?

    /**
     * Retrieves a fresh copy of the cached value.
     *
     * @return A fresh copy of the cached value, or null if the value is not available.
     */
    suspend fun fresh(): T?

    /**
     * Retrieves the last cached value if available, otherwise retrieves a fresh copy of the value.
     *
     * @return The last cached value if available, or a fresh copy of the value. Returns null if the value is not present in the cache.
     */
    suspend fun lastOrFresh() = last() ?: fresh()

    /**
     * Emits the cached value whenever it changes.
     * The flow updates an value in the cache based on the expiration of the key.
     *
     * @return A flow representing the changes to the cached value.
     */
    suspend fun changes(): Flow<T>

    companion object {
        /**
         * Creates a CacheState instance representing a passed value.
         *
         * @param key The cache key associated with the value.
         * @param value The cached value.
         * @return A CacheState instance representing the single cached value.
         */
        fun <T> of(key: CacheKey<T>, value: T): CacheEntry<T> = object : CacheEntry<T> {
            override val key: CacheKey<T> = key
            override suspend fun value(): T? = value
            override suspend fun last(): T? = value
            override suspend fun fresh(): T? = value
            override suspend fun changes(): Flow<T> = flowOf(value)
        }
    }

}