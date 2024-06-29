package kotli.app

import androidx.compose.runtime.Composable
import kotli.app.feature.navigation.BottomProvider
import kotli.app.feature.navigation.NavigationBarProvider
import kotli.app.ui.loader.LoaderProvider
import shared.design.container.AppScaffold
import shared.presentation.navigation.rememberNavigationContext
import shared.presentation.viewmodel.provideViewModel

/**
 * The main screen of the application.
 */
@Composable
fun AppScreen() {
    val viewModel: AppViewModel = provideViewModel()
    val navigationState = viewModel.navigationStore
    val navigationContext = rememberNavigationContext(navigationState)
    NavigationBarProvider { // {userflow.navigation}
        AppScaffold(
            snackbarState = viewModel.snackbarStore,
            navigationContext = navigationContext,
            bottomBar = { BottomProvider() }
        )
    } // {userflow.navigation}
    LoaderProvider(viewModel.appStore)
}
