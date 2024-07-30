package kotli.app.platform

import app.cash.sqldelight.db.SqlDriver

expect fun createSqlDriver(name: String): SqlDriver