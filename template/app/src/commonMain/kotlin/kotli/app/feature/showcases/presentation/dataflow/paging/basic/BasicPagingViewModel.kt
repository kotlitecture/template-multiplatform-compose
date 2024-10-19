package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import androidx.lifecycle.viewModelScope
import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import kotli.app.common.data.source.paging.AppPagingSource
import kotlinx.coroutines.flow.Flow
import shared.presentation.viewmodel.BaseViewModel

class BasicPagingViewModel(
    private val pagingSource: AppPagingSource
) : BaseViewModel() {

    val state: BasicPagingState by lazy {
        val pager = pagingSource.getPager(::BasicPagingSource)
        val items = pager.flow.cachedIn(viewModelScope)
        BasicPagingMutableState(items)
    }

    private class BasicPagingMutableState(
        override val items: Flow<PagingData<String>>
    ) : BasicPagingState

}
