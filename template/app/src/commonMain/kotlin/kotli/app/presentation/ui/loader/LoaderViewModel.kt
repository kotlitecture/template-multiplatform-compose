package kotli.app.presentation.ui.loader

import kotli.app.data.source.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.store.DataLoading
import shared.presentation.store.DataState
import shared.presentation.store.Store

class LoaderViewModel(
    private val configSource: AppConfigSource
) : BaseViewModel() {

    val isLoadingState = DataState(false)

    fun onBind(state: Store) {
        launchAsync("dataStateStore") {
            state.loadingState.asFlow()
                .filterNotNull()
                .map { it is DataLoading.InProgress }
                .distinctUntilChanged()
                .collectLatest { loading ->
                    if (loading) {
                        delay(configSource.getUiLoaderDelay())
                        isLoadingState.set(true)
                        delay(configSource.getUiLoaderTimeout())
                        isLoadingState.set(false)
                    } else {
                        isLoadingState.set(false)
                    }
                }
        }
    }

}