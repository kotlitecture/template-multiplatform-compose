package shared.presentation.state

import androidx.compose.runtime.Stable

/**
 * Base interface for UI events in the application.
 *
 * UI events represent one-time events that occur in the UI, such as user actions,
 * navigation events, or notifications that should be processed only once.
 *
 * This interface is marked with [Stable] annotation to ensure optimal recomposition
 * behavior when used with Compose.
 */
@Stable
interface UiEvent
