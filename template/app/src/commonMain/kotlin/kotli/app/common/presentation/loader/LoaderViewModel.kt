package kotli.app.common.presentation.loader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.common.data.source.config.AppConfigSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import shared.presentation.viewmodel.BaseViewModel

class LoaderViewModel(
    private val configSource: AppConfigSource
) : BaseViewModel() {

    private val _state = LoaderMutableState()
    val state: LoaderState = _state

    suspend fun onBind(isLoading: () -> Boolean) {
        snapshotFlow(isLoading).collectLatest { loading ->
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

    fun onClose() = state.cancel()
}

private class LoaderMutableState : LoaderState {
    override var loading: Boolean by mutableStateOf(false)
    override var error: Throwable? by mutableStateOf(null)
    override var id: String? by mutableStateOf(null)

    override suspend fun runCatching(id: String, withLoader: Boolean, block: suspend () -> Unit) {
        try {
            if (withLoader) {
                loading = true
            }
            block()
        } catch (th: Throwable) {
            Snapshot.withMutableSnapshot {
                this.error = th
                this.id = id
            }
        } finally {
            if (withLoader) {
                loading = false
            }
        }
    }

    override fun cancel() = Snapshot.withMutableSnapshot {
        loading = false
        error = null
        id = null
    }
}

fun LoaderState.Companion.create(): LoaderState = LoaderMutableState()