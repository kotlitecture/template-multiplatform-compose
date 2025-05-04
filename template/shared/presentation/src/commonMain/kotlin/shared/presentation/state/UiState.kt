package shared.presentation.state

import androidx.compose.runtime.Stable

/**
 * Represents the different states of a UI component.
 * 
 * This sealed interface provides a type-safe way to handle different UI states
 * in the application. It is marked with [Stable] annotation to ensure optimal
 * recomposition behavior when used with Compose.
 */
@Stable
sealed interface UiState {

    /**
     * Indicates that the UI is in a ready state and can accept user interactions.
     */
    object Ready : UiState

    /**
     * Indicates that the UI is in a loading state, typically showing a loading indicator
     * while allowing user interactions with the rest of the UI.
     */
    object Loading : UiState

    /**
     * Indicates that the UI is in a blocking state, typically showing a modal loading indicator
     * that prevents user interactions until the operation completes.
     */
    object Blocking : UiState

    /**
     * Represents an error state with information about the error.
     *
     * @property title The title or brief description of the error.
     * @property th The throwable that caused the error.
     * @property onExit Callback to be invoked when the user dismisses the error.
     */
    data class Error(
        val title: String,
        val th: Throwable,
        val onExit: () -> Unit
    ) : UiState
}

/**
 * Extension function to convert a [Throwable] to an [UiState.Error].
 *
 * @param title The title or brief description of the error.
 * @param onExit Callback to be invoked when the user dismisses the error.
 * @return An [UiState.Error] instance containing the error information.
 */
fun Throwable.toErrorState(title: String, onExit: () -> Unit) = UiState.Error(
    onExit = onExit,
    title = title,
    th = this
)
