package app.userflow.loader.data

import app.datasource.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.core.BaseViewModel
import shared.core.state.DataState
import shared.core.state.StoreObject
import shared.core.state.StoreState

class DataLoaderViewModel(
    private val configSource: AppConfigSource
) : BaseViewModel() {

    val isLoadingStore = StoreObject(false)

    fun onBind(state: StoreState) {
        launchAsync("dataStateStore") {
            state.dataStateStore.asFlow()
                .filterNotNull()
                .map { it is DataState.Loading }
                .distinctUntilChanged()
                .collectLatest { loading ->
                    if (loading) {
                        delay(configSource.getUiLoadingDelay())
                        isLoadingStore.set(true)
                        delay(configSource.getUiLoadingTimeout())
                        isLoadingStore.set(false)
                    } else {
                        isLoadingStore.set(false)
                    }
                }
        }
    }

}