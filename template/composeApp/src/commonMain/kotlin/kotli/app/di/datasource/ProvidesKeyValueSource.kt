package kotli.app.di.datasource

import kotli.app.datasource.keyvalue.AppKeyValueSource
import shared.data.datasource.keyvalue.KeyValueSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesKeyValueSource = module {
    single { AppKeyValueSource() }.bind(KeyValueSource::class)
}