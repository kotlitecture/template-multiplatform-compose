package kotli.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.common.presentation.navigation.NavigationMutableState
import shared.design.component.AppSnackbarState

class AppMutableState(
    override val snackbarState: AppSnackbarState,
    override val navigationState: NavigationMutableState,
    override val transitionDuration: Int = 100
) : AppState {
    override var startDestination: Any? by mutableStateOf(null)
}