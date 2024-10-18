package kotli.app.di.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual fun createSqlDriver(name: String): SqlDriver {
    return JdbcSqliteDriver("jdbc:sqlite:$name")
}