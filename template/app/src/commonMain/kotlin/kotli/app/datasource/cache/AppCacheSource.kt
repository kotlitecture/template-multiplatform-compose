package kotli.app.datasource.cache

import shared.data.datasource.cache.InMemoryCacheSource

/**
 * Decorator class for working with L1 Cache.
 *
 * Can provide extra methods without impacting facade implementations.
 */
class AppCacheSource : InMemoryCacheSource()