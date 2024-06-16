package kotli.app.di.datasource

import kotli.app.datasource.database.sqldelight.AppSqlDelightSource
import org.koin.dsl.module

val ProvidesSqlDelightSource = module {
    single { AppSqlDelightSource() }
}