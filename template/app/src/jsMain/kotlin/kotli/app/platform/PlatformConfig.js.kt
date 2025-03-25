package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import org.koin.dsl.module
import org.w3c.dom.Worker

actual fun NavGraphBuilder.platform(navController: NavHostController) {
}

actual fun InitializerViewModelFactoryBuilder.platform() {
}

actual val platform = module {
    // {dataflow.database.sqldelight}
    single<SqlDriver> {
        WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
    }
    // {dataflow.database.sqldelight}
}