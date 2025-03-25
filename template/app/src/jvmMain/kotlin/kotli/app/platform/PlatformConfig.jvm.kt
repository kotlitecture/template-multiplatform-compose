package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.room.Room
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotli.app.common.data.source.database.DatabaseSource
import kotli.app.common.data.source.database.room.AppDatabase
import kotli.app.common.data.source.database.room.RoomSource
import kotli.app.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.datastore.DataStoreSource
import java.io.File

actual fun NavGraphBuilder.platform(navController: NavHostController) = Unit

actual fun InitializerViewModelFactoryBuilder.platform() = Unit

actual val platform = module {
    // {dataflow.database.room}
    single<DatabaseSource> {
        val dbName = "app.db"
        val dbFile = File(System.getProperty("java.io.tmpdir"), dbName)
        val dbBuilder = Room.databaseBuilder<AppDatabase>(dbFile.absolutePath)
        RoomSource(dbBuilder)
    }
    // {dataflow.database.room}
    // {dataflow.database.sqldelight}
    single<DatabaseSource> {
        val dbName = "app.db"
        val driver = JdbcSqliteDriver("jdbc:sqlite:${dbName}")
        SqlDelightSource(driver)
    }
    // {dataflow.database.sqldelight}
    // {dataflow.settings.datastore}
    single<SettingsSource> {
        val fileName = "app.preferences_pb"
        val file = File(System.getProperty("java.io.tmpdir"), fileName)
        DataStoreSource(file.absolutePath)
    }
    // {dataflow.settings.datastore}
}