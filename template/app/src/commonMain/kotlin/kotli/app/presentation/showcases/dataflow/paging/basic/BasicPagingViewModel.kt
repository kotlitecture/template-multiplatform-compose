package kotli.app.presentation.showcases.dataflow.paging.basic

import androidx.lifecycle.viewModelScope
import app.cash.paging.cachedIn
import kotli.app.common.data.source.paging.AppPagingSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class BasicPagingViewModel(
    private val navigationStore: NavigationStore,
    private val pagingSource: AppPagingSource
) : BaseViewModel() {

    fun onBack() = navigationStore.onBack()

    val itemsFlow by lazy {
        val pager = pagingSource.getPager(::BasicPagingSource)
        pager.flow.cachedIn(viewModelScope)
    }

}
