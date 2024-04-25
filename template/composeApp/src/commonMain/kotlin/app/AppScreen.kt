package app

import androidx.compose.runtime.Composable
import app.ui.navigation.NavigationBarProvider
import app.ui.navigation.bottom.BottomNavigation
import core.ui.navigation.NavigationScaffold
import core.ui.navigation.rememberNavigationContext

@Composable
fun AppScreen() {
    val viewModel: AppViewModel = appViewModel(AppViewModel::class)
    val navigationContext = rememberNavigationContext(viewModel.navigationState)
    NavigationBarProvider {
        NavigationScaffold(
            navigationContext = navigationContext,
            bottomBar = { BottomNavigation() }
        )
    }
}
