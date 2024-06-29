package kotli.app.di.datasource

import kotli.app.data.source.database.sqldelight.AppSqlDelightSource
import org.koin.dsl.module

val ProvidesSqlDelightSource = module {
    single { AppSqlDelightSource() }
}