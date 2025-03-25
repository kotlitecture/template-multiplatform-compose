package kotli.app.showcases.presentation.dataflow.paging.basic

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import shared.data.source.paging.Pager
import shared.data.source.paging.PagingSource
import shared.presentation.viewmodel.BaseViewModel

class BasicPagingViewModel(pagingSource: PagingSource) : BaseViewModel() {

    private val allItems = (1..300).map { "Item-$it" }

    private val pager = pagingSource.createPager(viewModelScope) { limit, offset ->
        delay(1000)
        val items = allItems.drop(offset).take(limit)
        items
    }

    private val _state = BasicPagingMutableState(pager)
    val state: BasicPagingState = _state

    private class BasicPagingMutableState(
        override val items: Pager<String>
    ) : BasicPagingState

}
