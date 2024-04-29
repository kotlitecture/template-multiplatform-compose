package app

import androidx.compose.runtime.Composable
import app.userflow.navigation.NavigationBarProvider
import app.userflow.navigation.bottom.BottomNavigation
import core.ui.navigation.rememberNavigationContext
import shared.design.scaffold.NavigationScaffold

@Composable
fun AppScreen() {
    val viewModel: AppViewModel = appViewModel(AppViewModel::class)
    val navigationState = viewModel.navigationState
    NavigationBarProvider {
        NavigationScaffold(
            navigationContext = rememberNavigationContext(navigationState),
            bottomBar = { BottomNavigation() }
        )
    }
}
