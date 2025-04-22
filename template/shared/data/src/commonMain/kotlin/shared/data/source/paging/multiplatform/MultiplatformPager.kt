package shared.data.source.paging.multiplatform

import app.cash.paging.cachedIn
import app.cash.paging.createPager
import app.cash.paging.createPagingConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import shared.data.source.paging.PageLoader
import shared.data.source.paging.Pager

internal class MultiplatformPager<V : Any>(
    pageSize: Int,
    private val scope: CoroutineScope,
    private val loader: PageLoader<V>
) : Pager<V> {

    private var currentLoader: MultiplatformPageLoader<V>? = null

    private val pager by lazy {
        createPager(
            config = createPagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MultiplatformPageLoader(loader)
                    .also(this::currentLoader::set)
            }
        )
    }

    override fun pages(): Flow<Any> {
        return pager.flow.cachedIn(scope)
    }

    override fun refresh() {
        currentLoader?.invalidate()
    }
}