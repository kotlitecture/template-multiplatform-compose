package core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import core.ui.coreViewModel

/**
 * Composable function responsible for providing navigation functionality to the UI.
 *
 * @param navigationState The navigation state containing destination and navigation information.
 * @param navigationContext The application context containing navigation controller and other related components.
 */
@Composable
fun NavigationProvider(navigationState: NavigationState, navigationContext: NavigationContext) {
    val viewModel = coreViewModel(NavigationViewModel::class)
    DisposableEffect(navigationState, navigationContext) {
        viewModel.onBind(navigationState, navigationContext)
        onDispose { viewModel.onUnbind(navigationState) }
    }
}