package app.di.datasource

import app.datasource.config.AppConfigSource
import core.data.datasource.config.ConfigSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesConfigSource = module {
    single { AppConfigSource() }.bind(ConfigSource::class)
}