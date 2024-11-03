package kotli.app

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.design.component.AppSnackbarState

@Stable
interface AppState {
    val startDestination: Any?
    val transitionDuration: Int
    val snackbarState: AppSnackbarState
}

class AppMutableState(
    override val snackbarState: AppSnackbarState,
    override val transitionDuration: Int = 0,
) : AppState {
    override var startDestination: Any? by mutableStateOf(null)
}