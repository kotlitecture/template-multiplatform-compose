package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import kotli.app.common.data.source.database.DatabaseSource
import kotli.app.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import org.w3c.dom.Worker

actual fun NavGraphBuilder.platform(navController: NavHostController) = Unit

actual fun InitializerViewModelFactoryBuilder.platform() = Unit

actual val platform = module {
    // {dataflow.database.sqldelight}
    single<DatabaseSource> {
        val driver = WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        SqlDelightSource(driver)
    }
    // {dataflow.database.sqldelight}
}