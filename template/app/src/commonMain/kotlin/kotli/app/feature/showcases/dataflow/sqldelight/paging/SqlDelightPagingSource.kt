package kotli.app.feature.showcases.dataflow.sqldelight.paging

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import app.cash.sqldelight.async.coroutines.awaitAsList
import kotli.app.common.data.source.database.sqldelight.AppSqlDelightSource
import kotli.app.common.data.source.database.sqldelight.User

class SqlDelightPagingSource(private val databaseSource: AppSqlDelightSource) :
    PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? = null

    override suspend fun load(
        params: PagingSourceLoadParams<Int>
    ): PagingSourceLoadResult<Int, User> {
        val offset = params.key ?: 0
        val pageSize = params.loadSize
        val query = databaseSource.getDatabase().userQueries
        val items = query.getAllPaginated(pageSize.toLong(), offset.toLong()).awaitAsList()
        return PagingSourceLoadResultPage(
            data = items,
            prevKey = (offset - pageSize).takeIf { it >= 0 },
            nextKey = (offset + items.size).takeIf { it != offset }
        ) as PagingSourceLoadResult<Int, User>
    }
}