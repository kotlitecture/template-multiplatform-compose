package kotli.app.di.datasource

import kotli.app.data.source.config.AppConfigSource
import shared.data.source.config.ConfigSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesConfigSource = module {
    single { AppConfigSource() }.bind(ConfigSource::class)
}