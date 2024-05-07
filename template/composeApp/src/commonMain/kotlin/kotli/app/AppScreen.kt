package kotli.app

import androidx.compose.runtime.Composable
import kotli.app.feature.loader.data.DataLoaderProvider
import kotli.app.feature.navigation.NavigationBarProvider
import kotli.app.feature.navigation.BottomProvider
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
    val navigationContext = rememberNavigationContext(navigationState)
    NavigationBarProvider { // {userflow.navigation}
        AppScaffold(
            navigationContext = navigationContext,
            bottomBar = { BottomProvider() }
        )
    } // {userflow.navigation}
    DataLoaderProvider(viewModel.appState)
}
