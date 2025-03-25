## Overview

The API can be accessed through:
- `shared.data.source.cache.CacheSource` - facade interface at the core module level.

Facade **CacheSource** provides the following methods:

- `get(key: CacheKey<T>, valueProvider: suspend () -> T?): CacheEntry<T>` - Retrieves the cache entry associated with the specified key.
- `invalidate(type: Class<K>)` - Invalidates all cache entries associated with the specified key type.
- `invalidate(key: K)` - Invalidates the cache entry associated with the specified key.
- `remove(type: Class<K>)` - Removes all cache entries associated with the specified key type.
- `remove(key: K)` - Removes the cache entry associated with the specified key.
- `clear()` - Clears all entries from the cache. 

## Example

The **facade** is pre-configured via dependency injection (DI) as singletons in `app.common.CommonConfig`.

To start using, just inject it to your DI managed class.

```kotlin
class BasicCacheViewModel(
    private val cacheSource: CacheSource
) : BaseViewModel() {

    private val _state = BasicCacheMutableState()
    val state: BasicCacheState = _state

    override fun doBind() = async("Load data from cache") {
        val cacheKey = SimpleCacheKey("yyyy-MM-dd HH:mm:ss")
        val cacheEntry = cacheSource.get(cacheKey, ::getDateAsFormattedString)
        cacheEntry.changes().collectLatest(_state::cache::set)
    }

    private fun getDateAsFormattedString(key: SimpleCacheKey): String {
        val time = Clock.System.now()
        return time.format(DateTimeComponents.Format {
            byUnicodePattern(key.pattern)
        })
    }

    private data class SimpleCacheKey(
        val pattern: String,
        override val ttl: Long = CacheKey.TTL_10_SECONDS
    ) : CacheKey<String>

    private class BasicCacheMutableState : BasicCacheState {
        override var cache: String? by mutableStateOf(null)
    }
}
```