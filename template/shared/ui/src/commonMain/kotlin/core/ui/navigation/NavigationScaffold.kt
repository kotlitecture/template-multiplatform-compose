package core.ui.navigation

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        snackbarHost = { SnackbarHost(navigationContext.snackbarHostSate) },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.only(WindowInsetsSides.Horizontal),
        content = {
            NavigationHost(
                modifier = Modifier.padding(it),
                navigationState = navigationState,
                startDestination = startDestination,
                navigationContext = navigationContext
            )
        }
    )
}