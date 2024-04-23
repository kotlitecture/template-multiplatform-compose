package app

import androidx.compose.runtime.Composable
import core.ui.navigation.NavigationScaffold
import core.ui.navigation.rememberNavigationContext

@Composable
fun AppScreen() {
    val viewModel: AppViewModel = appViewModel(AppViewModel::class)
    val navigationContext = rememberNavigationContext(viewModel.navigationState)
    NavigationScaffold(
        navigationContext = navigationContext
    )
}
