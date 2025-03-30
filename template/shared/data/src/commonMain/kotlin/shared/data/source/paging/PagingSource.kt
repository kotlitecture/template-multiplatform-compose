package shared.data.source.paging

import kotlinx.coroutines.CoroutineScope

interface PagingSource {

    fun <V : Any> createPager(scope: CoroutineScope, loader: PageLoader<V>): Pager<V>
}