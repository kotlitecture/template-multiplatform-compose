package kotli.app.di

import kotli.app.di.data.dataStoreSourceModule
import kotli.app.di.data.roomSourceModule
import org.koin.core.KoinApplication

actual fun configure(app: KoinApplication) {
    app.modules(
        roomSourceModule,
        dataStoreSourceModule
    )
}