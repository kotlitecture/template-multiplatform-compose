package kotli.app.presentation.app

import androidx.compose.runtime.Composable
import kotli.app.common.presentation.loader.LoaderDialog
import kotli.app.presentation.navigation.BottomProvider
import kotli.app.presentation.navigation.NavigationBarProvider
import kotli.app.presentation.passcode.PasscodeProvider
import shared.design.container.AppScaffold
import shared.presentation.navigation.rememberNavigationContext
import shared.presentation.store.DataLoading
import shared.presentation.viewmodel.provideViewModel

/**
 * The main screen of the application.
 */
@Composable
fun AppScreen() {
    val viewModel: AppViewModel = provideViewModel()
    val navigationStore = viewModel.navigationStore
    val navigationContext = rememberNavigationContext(navigationStore)
    PasscodeProvider { // {userflow.passcode.local}
        NavigationBarProvider { // {userflow.navigation}
            AppScaffold(
                snackbarState = viewModel.snackbarStore,
                navigationContext = navigationContext,
                bottomBar = { BottomProvider() }
            )
        } // {userflow.navigation}
        LoaderDialog { viewModel.appStore.loadingState.get() is DataLoading }
    } // {userflow.passcode.local}
}
