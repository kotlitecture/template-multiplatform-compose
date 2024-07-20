package kotli.app.factory

import app.cash.sqldelight.db.SqlDriver

expect fun createSqlDriver(name: String): SqlDriver