package kotli.app.presentation.loader

import kotli.app.data.source.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.store.DataLoading
import shared.presentation.store.DataState
import shared.presentation.store.Store
import shared.presentation.viewmodel.BaseViewModel

class LoaderViewModel(
    private val configSource: AppConfigSource
) : BaseViewModel() {

    val uiState = DataState(false)

    fun onBind(store: Store) = launchAsync("Handle loading state") {
        store.loadingState.asFlow()
            .filterNotNull()
            .map { state -> state is DataLoading.InProgress }
            .distinctUntilChanged()
            .collectLatest { loading ->
                if (loading) {
                    delay(configSource.getUiLoaderDelay())
                    uiState.set(true)
                    delay(configSource.getUiLoaderTimeout())
                    uiState.set(false)
                } else {
                    uiState.set(false)
                }
            }
    }

}