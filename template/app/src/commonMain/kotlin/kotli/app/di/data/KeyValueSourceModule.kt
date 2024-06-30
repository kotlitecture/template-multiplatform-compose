package kotli.app.di.data

import kotli.app.data.source.keyvalue.AppKeyValueSource
import shared.data.source.keyvalue.KeyValueSource
import org.koin.dsl.bind
import org.koin.dsl.module

val keyValueSourceModule = module {
    single { AppKeyValueSource() }.bind(KeyValueSource::class)
}