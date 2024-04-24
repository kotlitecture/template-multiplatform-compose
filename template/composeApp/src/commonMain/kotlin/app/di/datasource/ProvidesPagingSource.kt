package app.di.datasource

import app.datasource.config.AppConfigSource
import app.datasource.paging.AppPagingSource
import org.koin.dsl.module

val ProvidesPagingSource = module {
    single { AppPagingSource(get<AppConfigSource>().getPagingPageSize()) }
}