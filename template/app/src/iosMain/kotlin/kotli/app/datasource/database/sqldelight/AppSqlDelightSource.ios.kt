package kotli.app.datasource.database.sqldelight

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual fun createSqlDriver(name: String): SqlDriver {
    return NativeSqliteDriver(AppDatabase.Schema.synchronous(), name)
}