package kotli.app

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.feature.navigation.provide.presentation.NavigationMutableState
import kotli.app.common.presentation.navigation.NavigationState
import shared.design.component.AppSnackbarState

@Stable
interface AppState {
    val navigationState: NavigationState
    val snackbarState: AppSnackbarState
    val startDestination: Any?
    val transitionDuration: Int
}

class AppMutableState(
    override val snackbarState: AppSnackbarState,
    override val navigationState: NavigationMutableState,
    override val transitionDuration: Int = 100
) : AppState {
    override var startDestination: Any? by mutableStateOf(null)
}