package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import kotli.app.Application
import kotli.app.common.data.source.database.room.AppRoomSource
import kotli.app.common.data.source.database.sqldelight.AppDatabase
import org.koin.dsl.module
import shared.data.source.settings.datastore.DataStoreSource
import shared.data.source.settings.SettingsSource

actual fun NavGraphBuilder.platform(navController: NavHostController) {
}

actual fun InitializerViewModelFactoryBuilder.platform() {
}

actual val platform = module {
    // {dataflow.database.room}
    single {
        AppRoomSource()
    }
    // {dataflow.database.room}
    // {dataflow.database.sqldelight}
    single {
        AndroidSqliteDriver(AppDatabase.Schema.synchronous(), Application.ref, it.get())
    }
    // {dataflow.database.sqldelight}
    // {dataflow.settings.datastore}
    single<SettingsSource> {
        val fileName = "app.preferences_pb"
        val path = Application.ref.filesDir.resolve(fileName).absolutePath
        DataStoreSource(path)
    }
    // {dataflow.settings.datastore}
}