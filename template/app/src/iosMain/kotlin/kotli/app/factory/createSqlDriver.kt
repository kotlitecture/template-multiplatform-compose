package kotli.app.factory

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import kotli.app.data.source.database.sqldelight.AppDatabase

actual fun createSqlDriver(name: String): SqlDriver {
    return NativeSqliteDriver(AppDatabase.Schema.synchronous(), name)
}