package kotli.app

import androidx.compose.runtime.Stable
import kotli.app.common.presentation.navigation.NavigationState
import shared.design.component.AppSnackbarState

@Stable
interface AppState {

    val navigationState: NavigationState
    val snackbarState: AppSnackbarState
    val startDestination: Any?

}