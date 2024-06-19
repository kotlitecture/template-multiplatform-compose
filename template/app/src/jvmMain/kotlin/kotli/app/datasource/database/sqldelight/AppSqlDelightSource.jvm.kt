package kotli.app.datasource.database.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotlinx.coroutines.runBlocking

actual fun createSqlDriver(name: String): SqlDriver {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$name")
    runBlocking { AppDatabase.Schema.create(driver).await() }
    return driver
}