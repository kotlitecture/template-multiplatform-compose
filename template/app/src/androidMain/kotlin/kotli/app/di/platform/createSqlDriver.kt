package kotli.app.di.platform

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import kotli.app.Application
import kotli.app.common.data.source.database.sqldelight.AppDatabase

actual fun createSqlDriver(name: String): SqlDriver {
    val context = Application.instance
    return AndroidSqliteDriver(AppDatabase.Schema.synchronous(), context, name)
}