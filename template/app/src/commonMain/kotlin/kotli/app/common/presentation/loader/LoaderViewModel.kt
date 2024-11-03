package kotli.app.common.presentation.loader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import shared.data.misc.isCancellationException
import shared.presentation.viewmodel.BaseViewModel

class LoaderViewModel : BaseViewModel() {

    private val _state = LoaderMutableState()
    val state: LoaderState = _state

    suspend fun onBind(isLoading: () -> Boolean) {
        snapshotFlow(isLoading).collectLatest { loading ->
            if (loading) {
                delay(_state.delay)
                _state.loading = true
                delay(_state.timeout)
                _state.loading = false
            } else {
                _state.loading = false
            }
        }
    }

    fun onClose() = state.cancel()
}

private class LoaderMutableState : LoaderState {
    override val delay: Long = 50
    override val timeout: Long = 30_000
    override var loading: Boolean by mutableStateOf(false)
    override var error: Throwable? by mutableStateOf(null)
    override var id: String? by mutableStateOf(null)

    override suspend fun runCatching(
        label: String,
        withLoader: Boolean,
        block: suspend () -> Unit
    ) {
        try {
            if (withLoader) {
                loading = true
            }
            block()
        } catch (th: Throwable) {
            if (!th.isCancellationException()) {
                Snapshot.withMutableSnapshot {
                    this.error = th
                    this.id = label
                }
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