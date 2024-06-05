package kotli.app.showcases.datasource.paging.basic

import androidx.lifecycle.viewModelScope
import app.cash.paging.cachedIn
import kotli.app.datasource.paging.AppPagingSource
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState

class BasicPagingViewModel(
    private val navigationState: NavigationState,
    private val pagingSource: AppPagingSource
) : BaseViewModel() {

    val itemsFlow by lazy {
        val pager = pagingSource.getPager { BasicPagingSource() }
        pager.flow.cachedIn(viewModelScope)
    }

    fun onBack() {
        navigationState.onBack()
    }

}
