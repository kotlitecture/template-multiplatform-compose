package shared.data.source.paging.multiplatform

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import shared.data.source.paging.PageLoader

internal class MultiplatformPageLoader<V : Any>(
    private val loader: PageLoader<V>
) : PagingSource<Int, V>() {

    override fun getRefreshKey(state: PagingState<Int, V>): Int? = null

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, V> {
        val offset = params.key ?: 0
        val limit = params.loadSize
        val items = loader.load(limit, offset)

        return PagingSourceLoadResultPage(
            data = items,
            prevKey = (offset - limit).takeIf { it >= 0 },
            nextKey = (offset + items.size).takeIf { it != offset }
        ) as PagingSourceLoadResult<Int, V>
    }
}