package kotli.app

import androidx.compose.runtime.Composable
import kotli.app.userflow.loader.data.DataLoaderProvider
import kotli.app.userflow.navigation.NavigationBarProvider
import kotli.app.userflow.navigation.BottomProvider
import shared.core.navigation.rememberNavigationContext
import shared.core.provideViewModel
import shared.design.container.AppScaffold

/**
 * The main screen of the application.
 */
@Composable
fun AppScreen() {
    val viewModel: AppViewModel = provideViewModel()
    val navigationState = viewModel.navigationState
    NavigationBarProvider { // {userflow.navigation}
        AppScaffold(
            navigationContext = rememberNavigationContext(navigationState),
            bottomBar = { BottomProvider() }
        )
    } // {userflow.navigation}
    DataLoaderProvider(viewModel.appState)
}
