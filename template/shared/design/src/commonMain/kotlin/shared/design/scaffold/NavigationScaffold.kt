package shared.design.scaffold

import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import shared.core.navigation.NavigationContext
import shared.core.navigation.NavigationHost
import shared.design.component.error.ErrorDialogProvider

/**
 * Composable function to display the main scaffold of the app.
 *
 * @param navigationContext The navigationContext of the navigation.
 * @param topBar The composable function to display the top bar.
 * @param bottomBar The composable function to display the bottom bar.
 * @param floatingActionButton The composable function to display the floating action button.
 * @param floatingActionButtonPosition The position of the floating action button.
 */
@Composable
fun NavigationScaffold(
    navigationContext: NavigationContext,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End
) {
    val navigationState = navigationContext.navigationState
    val startDestination = navigationState.startDestinationStore.asStateValue() ?: return
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButtonPosition = floatingActionButtonPosition,
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
    ErrorDialogProvider(navigationState)
}