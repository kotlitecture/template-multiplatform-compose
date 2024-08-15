package kotli.app.platform

import kotli.app.data.source.database.room.AppRoomSource
import org.koin.core.KoinApplication
import org.koin.dsl.module
import shared.data.source.keyvalue.DataStoreSource
import shared.data.source.keyvalue.KeyValueSource

actual fun configureKoin(app: KoinApplication) {
    app.modules(
        module {
            single { AppRoomSource() }
            single<KeyValueSource> { DataStoreSource(createDataStorePath()) }
        }
    )
}