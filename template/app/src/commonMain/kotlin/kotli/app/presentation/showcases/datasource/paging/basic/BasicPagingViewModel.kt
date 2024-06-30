package kotli.app.presentation.showcases.datasource.paging.basic

import androidx.lifecycle.viewModelScope
import app.cash.paging.cachedIn
import kotli.app.data.source.paging.AppPagingSource
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class BasicPagingViewModel(
    private val navigationStore: NavigationStore,
    private val pagingSource: AppPagingSource
) : BaseViewModel() {

    val itemsFlow by lazy {
        val pager = pagingSource.getPager { BasicPagingSource() }
        pager.flow.cachedIn(viewModelScope)
    }

    fun onBack() {
        navigationStore.onBack()
    }

}
