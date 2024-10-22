package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import kotlinx.coroutines.delay

class BasicPagingSource(private val loadDelay: Long = 1000) : PagingSource<Int, String>() {

    private val allItems = (1..300).map { "Item-$it" }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? = null

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, String> {
        val offset = params.key ?: 0
        val pageSize = params.loadSize
        val items = allItems.drop(offset).take(pageSize)
        delay(loadDelay)
        return PagingSourceLoadResultPage(
            data = items,
            prevKey = (offset - pageSize).takeIf { it >= 0 },
            nextKey = (offset + items.size).takeIf { it != offset }
        ) as PagingSourceLoadResult<Int, String>
    }
}