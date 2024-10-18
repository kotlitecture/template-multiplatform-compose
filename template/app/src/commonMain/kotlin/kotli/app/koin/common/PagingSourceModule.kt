package kotli.app.koin.common

import kotli.app.common.data.source.config.AppConfigSource
import kotli.app.common.data.source.paging.AppPagingSource
import org.koin.dsl.module

val pagingSourceModule = module {
    single { AppPagingSource(get<AppConfigSource>().getPagingPageSize()) }
}