package kotli.app.di.common

import kotli.app.common.data.source.paging.AppPagingSource
import org.koin.dsl.module

val pagingSourceModule = module {
    single { AppPagingSource(pageSize = 30) }
}