package kotli.app.di.datasource

import kotli.app.datasource.config.AppConfigSource
import kotli.app.datasource.paging.AppPagingSource
import org.koin.dsl.module

val ProvidesPagingSource = module {
    single { AppPagingSource(get<AppConfigSource>().getPagingPageSize()) }
}