package app

import androidx.compose.runtime.Composable
import app.userflow.loader.data.DataLoaderProvider
import app.userflow.navigation.NavigationBarProvider
import app.userflow.navigation.BottomProvider
import shared.core.navigation.rememberNavigationContext
import shared.core.provideViewModel
import shared.design.container.AppScaffold

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
