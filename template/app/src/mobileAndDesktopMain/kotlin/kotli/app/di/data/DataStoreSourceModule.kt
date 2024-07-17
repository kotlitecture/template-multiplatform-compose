package kotli.app.di.data

import org.koin.dsl.module
import shared.data.source.keyvalue.DataStoreSource
import shared.data.source.keyvalue.KeyValueSource

expect fun createDataStorePath(fileName: String): String

val dataStoreSourceModule = module {
    single<KeyValueSource> { DataStoreSource(createDataStorePath("app.preferences_pb")) }
}