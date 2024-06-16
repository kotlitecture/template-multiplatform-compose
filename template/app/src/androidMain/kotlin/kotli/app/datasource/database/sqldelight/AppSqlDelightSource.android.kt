package kotli.app.datasource.database.sqldelight

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import kotli.app.Application

actual fun createSqlDriver(name: String): SqlDriver {
    val context: Context = Application.instance
    return AndroidSqliteDriver(AppDatabase.Schema.synchronous(), context, name)
}