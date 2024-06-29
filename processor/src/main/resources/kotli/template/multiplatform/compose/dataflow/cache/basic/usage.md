## Overview

The API can be accessed through:
- `shared.data.source.cache.CacheSource` - facade interface at the core module level.
- `app.data.source.cache.AppCacheSource` - decorator class at the app level.

The difference is that the class serves as a **decorator** and can provide extra methods without impacting facade implementations.

Facade **CacheSource** provides the following methods:

- `get(key: CacheKey<T>, valueProvider: suspend () -> T?): CacheEntry<T>` - Retrieves the cache entry associated with the specified key.
- `invalidate(type: Class<K>)` - Invalidates all cache entries associated with the specified key type.
- `invalidate(key: K)` - Invalidates the cache entry associated with the specified key.
- `remove(type: Class<K>)` - Removes all cache entries associated with the specified key type.
- `remove(key: K)` - Removes the cache entry associated with the specified key.
- `put(key: CacheKey<T>, value: T)` - Associates the specified value with the specified key in the cache.
- `clear()` - Clears all entries from the cache. 

## Example

Both the **facade** and **decorator** are pre-configured via dependency injection (DI) as singletons in `app.di.datasource.ProvidesCacheSource`.

To start using, just inject it to your DI managed class.

```kotlin
class BasicCacheViewModel(
    private val cacheSource: CacheSource = get()
) : BaseViewModel() {

    val cacheState = DataState<String>()

    override fun doBind() {
        launchAsync {
            val cacheKey = SimpleCacheKey()
            val cacheEntry = cacheSource.get(cacheKey, ::getDateAsFormattedString)
            cacheEntry.changes().collectLatest(cacheState::set)
        }
    }

    private fun getDateAsFormattedString(): String {
        val time = Clock.System.now()
        return time.format(DateTimeComponents.Format {
            byUnicodePattern("yyyy-MM-dd HH:mm:ss")
        })
    }

    private data class SimpleCacheKey(
        override val ttl: Long = CacheKey.TTL_10_SECONDS
    ) : CacheKey<String>

}
```