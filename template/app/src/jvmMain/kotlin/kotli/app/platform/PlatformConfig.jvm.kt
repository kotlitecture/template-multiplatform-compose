package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotli.app.common.data.source.database.room.AppRoomSource
import org.koin.dsl.module
import shared.data.source.settings.datastore.DataStoreSource
import shared.data.source.settings.SettingsSource
import java.io.File

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
        JdbcSqliteDriver("jdbc:sqlite:${it.get<String>()}")
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