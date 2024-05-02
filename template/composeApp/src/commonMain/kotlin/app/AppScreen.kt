package app

import androidx.compose.runtime.Composable
import app.userflow.loader.data.DataLoaderProvider
import app.userflow.navigation.NavigationBarProvider
import app.userflow.navigation.provider.BottomProvider
import shared.core.navigation.rememberNavigationContext
import shared.core.provideViewModel
import shared.design.container.AppScaffold

@Composable
fun AppScreen() {
    val viewModel: AppViewModel = provideViewModel()
    val navigationState = viewModel.navigationState
    NavigationBarProvider {
        AppScaffold(
            navigationContext = rememberNavigationContext(navigationState),
            bottomBar = { BottomProvider() }
        )
    }
    DataLoaderProvider(viewModel.appState)
}
