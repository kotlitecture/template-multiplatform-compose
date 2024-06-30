package kotli.app.di.data

import kotli.app.data.source.cache.AppCacheSource
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.data.source.cache.CacheSource

val cacheSourceModule = module {
    single { AppCacheSource() }.bind(CacheSource::class)
}