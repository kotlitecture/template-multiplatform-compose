package kotli.app.common.data.source.cache

import shared.data.source.cache.BasicCacheSource

/**
 * Decorator class for working with L1 Cache.
 *
 * Can provide extra methods without impacting facade implementations.
 */
class AppCacheSource : BasicCacheSource()