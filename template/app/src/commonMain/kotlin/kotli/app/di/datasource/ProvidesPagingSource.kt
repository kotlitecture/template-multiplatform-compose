package kotli.app.di.datasource

import kotli.app.data.source.config.AppConfigSource
import kotli.app.data.source.paging.AppPagingSource
import org.koin.dsl.module

val ProvidesPagingSource = module {
    single { AppPagingSource(get<AppConfigSource>().getPagingPageSize()) }
}