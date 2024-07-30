package shared.data.source.cache

fun interface CacheEntryResolver<T, K : CacheKey<T>> {

    suspend fun resolve(key: K): T?

}