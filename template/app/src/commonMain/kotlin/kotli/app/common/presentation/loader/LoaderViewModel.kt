package kotli.app.common.presentation.loader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotli.app.common.data.source.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import shared.presentation.viewmodel.BaseViewModel

class LoaderViewModel(
    private val configSource: AppConfigSource
) : BaseViewModel() {

    private val _state = MutableLoaderState()
    val state: LoaderState = _state

    suspend fun onBind(isLoading: () -> Boolean) {
        snapshotFlow(isLoading)
            .filterNotNull()
            .distinctUntilChanged()
            .collectLatest { loading ->
                if (loading) {
                    delay(configSource.getUiLoaderDelay())
                    _state.loading = true
                    delay(configSource.getUiLoaderTimeout())
                    _state.loading = false
                } else {
                    _state.loading = false
                }
            }
    }

    private class MutableLoaderState : LoaderState {
        override var loading: Boolean by mutableStateOf(false)
    }
}