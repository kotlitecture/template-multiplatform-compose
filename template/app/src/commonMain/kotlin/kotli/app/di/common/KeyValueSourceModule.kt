package kotli.app.di.common

import org.koin.dsl.module
import shared.data.source.keyvalue.KeyValueSource
import shared.data.source.keyvalue.SettingsKeyValueSource

val keyValueSourceModule = module {
    single<KeyValueSource> { SettingsKeyValueSource() }
}