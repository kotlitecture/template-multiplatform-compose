package shared.data.source.paging.multiplatform

import kotlinx.coroutines.CoroutineScope
import shared.data.source.paging.PageLoader
import shared.data.source.paging.Pager
import shared.data.source.paging.PagingSource

class MultiplatformPagingSource(private val pageSize: Int = 30) : PagingSource {

    override fun <V : Any> createPager(scope: CoroutineScope, loader: PageLoader<V>): Pager<V> {
        return MultiplatformPager(pageSize, scope, loader)
    }
}