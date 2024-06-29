package kotli.app.di.datasource

import kotli.app.data.source.keyvalue.AppKeyValueSource
import shared.data.source.keyvalue.KeyValueSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesKeyValueSource = module {
    single { AppKeyValueSource() }.bind(KeyValueSource::class)
}