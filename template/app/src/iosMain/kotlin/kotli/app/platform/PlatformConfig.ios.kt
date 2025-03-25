package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import kotli.app.common.data.source.database.room.AppRoomSource
import kotli.app.common.data.source.database.sqldelight.AppDatabase
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask
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
    single<SqlDriver> {
        NativeSqliteDriver(AppDatabase.Schema.synchronous(), it.get())
    }
    // {dataflow.database.sqldelight}
    // {dataflow.settings.datastore}
    single<SettingsSource> {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        val fileName = "app.preferences_pb"
        val directory = requireNotNull(documentDirectory).path
        val path = "${directory}/$fileName"
        DataStoreSource(path)
    }
    // {dataflow.settings.datastore}
}