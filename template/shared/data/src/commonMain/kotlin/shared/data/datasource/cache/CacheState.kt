package shared.data.datasource.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Represents the state of a cache entry.
 *
 * @param T The type of the cached item.
 */
interface CacheState<T> {

    /** The key associated with this cache state. */
    val key: CacheKey<T>

    /**
     * Retrieves the cached item.
     *
     * @return The cached item, or new one if the item is not present in the cache or expired.
     */
    suspend fun get(): T?

    /**
     * Retrieves the last cached item.
     *
     * @return The last cached item, or null if the item is not present in the cache.
     */
    suspend fun last(): T?

    /**
     * Retrieves a fresh copy of the cached item.
     *
     * @return A fresh copy of the cached item, or null if the item is not available.
     */
    suspend fun fresh(): T?

    /**
     * Retrieves the last cached item if available, otherwise retrieves a fresh copy of the item.
     *
     * @return The last cached item if available, or a fresh copy of the item. Returns null if the item is not present in the cache.
     */
    suspend fun lastOrFresh() = last() ?: fresh()

    /**
     * Emits the cached item whenever it changes.
     * The flow updates an item in the cache based on the expiration of the key.
     *
     * @return A flow representing the changes to the cached item.
     */
    suspend fun changes(): Flow<T>

    companion object {
        /**
         * Creates a CacheState instance representing a passed item.
         *
         * @param key The cache key associated with the item.
         * @param item The cached item.
         * @return A CacheState instance representing the single cached item.
         */
        fun <T> single(key: CacheKey<T>, item: T): CacheState<T> = object : CacheState<T> {
            override val key: CacheKey<T> = key
            override suspend fun get(): T? = item
            override suspend fun last(): T? = item
            override suspend fun fresh(): T? = item
            override suspend fun changes(): Flow<T> = flowOf(item)
        }
    }

}