package kotli.app.common.data.source.database.sqldelight

import kotli.app.common.data.source.database.sqldelight.AppDatabase
import kotli.app.platform.createSqlDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import shared.data.source.DataSource

/**
 * This class represents a source for accessing the SqlDelight database.
 *
 * It provides access to all underlying DAO objects as well.
 *
 * @property databaseName The name of the database.
 */
class AppSqlDelightSource(
    private val databaseName: String = "app.db"
) : DataSource {

    private val db = flow {
        val driver = createSqlDriver(databaseName)
        AppDatabase.Schema.create(driver).await()
        val database = AppDatabase.invoke(driver)
        emit(database)
    }.shareIn(GlobalScope, SharingStarted.Lazily, 1)

    suspend fun getDatabase(): AppDatabase = db.first()

}

