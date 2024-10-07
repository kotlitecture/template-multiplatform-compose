package kotli.app.di.data

import kotli.app.common.data.source.database.sqldelight.AppSqlDelightSource
import org.koin.dsl.module

val sqlDelightSourceModule = module {
    single { AppSqlDelightSource() }
}