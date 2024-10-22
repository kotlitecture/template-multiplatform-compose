package kotli.app.di.platform

import app.cash.sqldelight.db.SqlDriver

expect fun createSqlDriver(name: String): SqlDriver