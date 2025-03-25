package shared.data.source.paging

import kotlinx.coroutines.flow.Flow

interface Pager<V : Any> {

    fun pages(): Flow<Any>

    fun refresh()
}