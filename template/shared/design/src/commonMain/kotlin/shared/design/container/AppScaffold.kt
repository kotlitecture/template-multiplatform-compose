package shared.design.container

import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import shared.design.component.AppErrorDialog
import shared.design.component.AppSnackbarStore
import shared.presentation.navigation.NavigationContext
import shared.presentation.navigation.NavigationHost

/**
 * Composable function to display the main scaffold of the app.
 *
 * @param navigationContext The navigationContext of the navigation.
 * @param topBar The composable function to display the top bar.
 * @param bottomBar The composable function to display the bottom bar.
 * @param floatingActionButton The composable function to display the floating action button.
 */
@Composable
fun AppScaffold(
    navigationContext: NavigationContext,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    snackbarState: AppSnackbarStore = remember { AppSnackbarStore() }
) {
    val navigationState = navigationContext.navigationStore
    val startDestination = navigationState.startDestinationState.asStateValue() ?: return
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.End,
        snackbarHost = { SnackbarHost(snackbarState.hostState) },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(ScaffoldDefaults.contentWindowInsets),
        content = {
            NavigationHost(
                modifier = Modifier.padding(it),
                navigationState = navigationState,
                startDestination = startDestination,
                navigationContext = navigationContext
            )
        }
    )
    AppErrorDialog(navigationState.loadingState)
}