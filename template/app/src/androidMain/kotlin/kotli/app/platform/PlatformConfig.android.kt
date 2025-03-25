package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.room.Room
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import kotli.app.Application
import kotli.app.common.data.source.database.DatabaseSource
import kotli.app.common.data.source.database.room.RoomSource
import kotli.app.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.datastore.DataStoreSource
import kotli.app.common.data.source.database.room.AppDatabase as RoomDatabase
import kotli.app.common.data.source.database.sqldelight.AppDatabase as SqlDelightDatabase

actual fun NavGraphBuilder.platform(navController: NavHostController) {
}

actual fun InitializerViewModelFactoryBuilder.platform() {
}

actual val platform = module {
    // {dataflow.database.room}
    single<DatabaseSource> {
        val dbName = "app.db"
        val context = Application.ref
        val dbFile = context.getDatabasePath(dbName)
        val dbBuilder = Room.databaseBuilder<RoomDatabase>(context, dbFile.absolutePath)
        RoomSource(dbBuilder)
    }
    // {dataflow.database.room}
    // {dataflow.database.sqldelight}
    single<DatabaseSource> {
        val dbName = "app.db"
        val context = Application.ref
        val driver = AndroidSqliteDriver(SqlDelightDatabase.Schema.synchronous(), context, dbName)
        SqlDelightSource(driver)
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