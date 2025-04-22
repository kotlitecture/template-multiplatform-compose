package shared.presentation.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Interface representing the state of a view in the application.
 *
 * This interface provides access to the current UI state and a flow of UI events.
 * It is marked with [Stable] annotation to ensure optimal recomposition behavior
 * when used with Compose.
 */
@Stable
interface ViewState {

    /**
     * The current UI state of the view.
     */
    val uiState: UiState

    /**
     * Flow of UI events emitted by the view.
     */
    val uiEvent: Flow<UiEvent>
}

/**
 * Abstract implementation of [ViewState] with mutable properties.
 *
 * This class provides a base implementation for view states that can be modified
 * during the lifecycle of a view.
 *
 * @param initialState The initial UI state of the view. Defaults to [UiState.Ready].
 */
abstract class MutableViewState(initialState: UiState = UiState.Ready) : ViewState {

    /**
     * Mutable shared flow of UI events.
     */
    final override var uiEvent = MutableSharedFlow<UiEvent>()

    /**
     * Mutable UI state that triggers recomposition when changed.
     */
    final override var uiState by mutableStateOf(initialState)
}

/**
 * Extension function to safely execute a suspending operation with error handling.
 *
 * This function wraps the provided operation in a try-catch block and handles any
 * exceptions by updating the UI state to an error state.
 *
 * @param T The type of [MutableViewState] this function is extending.
 * @param title The title to use for the error state if an exception occurs.
 * @param onTry The suspending operation to execute.
 * @param onCatch Custom exception handler. By default, it converts non-cancellation
 *                exceptions to error states.
 */
suspend fun <T : MutableViewState> T.tryCatch(
    title: String,
    onTry: suspend T.() -> Unit,
    onCatch: suspend T.(Throwable) -> Unit = { th ->
        if (!th.isCancellationException()) {
            uiState = th.toErrorState(title) {
                uiState = UiState.Ready
            }
        }
    },
) {
    runCatching { onTry() }.onFailure { onCatch(it) }
}

/**
 * Extension function to emit a UI event from a [MutableViewState].
 *
 * @param T The type of [MutableViewState] this function is extending.
 * @param event The [UiEvent] to emit.
 */
suspend fun <T : MutableViewState> T.notify(event: UiEvent) {
    uiEvent.emit(event)
}

private fun Throwable.isCancellationException(): Boolean {
    var exception: Throwable? = this
    while (exception != null && exception !is CancellationException) {
        if (exception == exception.cause) return false
        exception = exception.cause
    }
    return exception is CancellationException
}
