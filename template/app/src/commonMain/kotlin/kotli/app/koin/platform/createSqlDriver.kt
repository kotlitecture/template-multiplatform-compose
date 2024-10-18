package kotli.app.koin.platform

import app.cash.sqldelight.db.SqlDriver

expect fun createSqlDriver(name: String): SqlDriver