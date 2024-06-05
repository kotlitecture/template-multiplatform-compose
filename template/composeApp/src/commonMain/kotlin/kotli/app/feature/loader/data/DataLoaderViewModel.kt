package kotli.app.feature.loader.data

import kotli.app.datasource.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.BaseViewModel
import shared.presentation.state.DataState
import shared.presentation.state.StoreObject
import shared.presentation.state.StoreState

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
                        delay(configSource.getDataLoaderDelay())
                        isLoadingStore.set(true)
                        delay(configSource.getDataLoaderTimeout())
                        isLoadingStore.set(false)
                    } else {
                        isLoadingStore.set(false)
                    }
                }
        }
    }

}