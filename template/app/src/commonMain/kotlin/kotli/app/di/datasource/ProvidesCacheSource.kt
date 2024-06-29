package kotli.app.di.datasource

import kotli.app.datasource.cache.AppCacheSource
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.data.source.cache.CacheSource

val ProvidesCacheSource = module {
    single { AppCacheSource() }.bind(CacheSource::class)
}