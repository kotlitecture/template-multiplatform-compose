package kotli.app.datasource.database.sqldelight

import app.cash.sqldelight.db.SqlDriver

expect fun createSqlDriver(name: String): SqlDriver

/**
 * This class represents a source for accessing the SqlDelight database.
 *
 * It provides access to all underlying DAO objects as well.
 *
 * @property databaseName The name of the database.
 */
class AppSqlDelightSource(
    private val databaseName: String = "app.db"
) {

    val database by lazy { AppDatabase.invoke(createSqlDriver(databaseName)) }

}