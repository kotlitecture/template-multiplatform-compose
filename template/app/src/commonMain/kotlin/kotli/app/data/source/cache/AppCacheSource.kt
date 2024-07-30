package kotli.app.data.source.cache

import shared.data.source.cache.MemoryCacheSource

/**
 * Decorator class for working with L1 Cache.
 *
 * Can provide extra methods without impacting facade implementations.
 */
class AppCacheSource : MemoryCacheSource()