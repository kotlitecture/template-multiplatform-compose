# Usage

## Overview

The API can be accessed through:
- `shared.data.datasource.cache.CacheSource` - facade interface at the core module level.
- `app.datasource.cache.AppCacheSource` - decorator class at the app level.

The difference is that the class serves as a **decorator** and can provide extra methods without impacting facade implementations.

Facade **CacheSource** provides the following methods:

- `getState(key: CacheKey<T>, valueProvider: suspend () -> T?): CacheState<T>` - Retrieves the state of a cache entry associated with the specified key.
- `get(key: CacheKey<T>, valueProvider: suspend () -> T?): T?` - Retrieves the value associated with the specified key from the cache.
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

    val cacheStore = DataState<String>()

    override fun doBind() {
        launchAsync {
            val cacheKey = SimpleCacheKey()
            val cacheState = cacheSource.getState(cacheKey, ::getDateAsFormattedString)
            cacheState.changes().collectLatest(cacheStore::set)
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
