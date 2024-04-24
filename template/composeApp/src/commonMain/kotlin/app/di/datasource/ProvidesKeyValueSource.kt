package app.di.datasource

import app.datasource.keyvalue.AppKeyValueSource
import core.data.datasource.keyvalue.KeyValueSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesKeyValueSource = module {
    single { AppKeyValueSource() }.bind(KeyValueSource::class)
}