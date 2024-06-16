package kotli.app.datasource.database.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual fun createSqlDriver(name: String): SqlDriver {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$name")
    AppDatabase.Schema.create(driver)
    return driver
}