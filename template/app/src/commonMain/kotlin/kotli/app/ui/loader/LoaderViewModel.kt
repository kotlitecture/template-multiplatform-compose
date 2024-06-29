package kotli.app.ui.loader

import kotli.app.datasource.config.AppConfigSource
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

    val isLoadingStore = DataState(false)

    fun onBind(state: Store) {
        launchAsync("dataStateStore") {
            state.loadingState.asFlow()
                .filterNotNull()
                .map { it is DataLoading.InProgress }
                .distinctUntilChanged()
                .collectLatest { loading ->
                    if (loading) {
                        delay(configSource.getUiLoaderDelay())
                        isLoadingStore.set(true)
                        delay(configSource.getUiLoaderTimeout())
                        isLoadingStore.set(false)
                    } else {
                        isLoadingStore.set(false)
                    }
                }
        }
    }

}