package shared.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import shared.presentation.viewmodel.ViewModelFactory
import shared.presentation.viewmodel.provideViewModel

/**
 * Composable function responsible for providing navigation functionality to the UI.
 *
 * @param navigationStore The navigation state containing destination and navigation information.
 * @param navigationContext The application context containing navigation controller and other related components.
 */
@Composable
fun NavigationProvider(navigationStore: NavigationStore, navigationContext: NavigationContext) {
    val viewModel: NavigationViewModel = provideViewModel(factory = remember { ViewModelFactory })
    DisposableEffect(navigationStore, navigationContext) {
        viewModel.onBind(navigationStore, navigationContext)
        onDispose { viewModel.onUnbind(navigationStore) }
    }
}