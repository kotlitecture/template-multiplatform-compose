package core.ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

/**
 * Immutable data class representing the navigation context, including essential components like
 * navigation controller, coroutine scope, and context.
 *
 * @param snackbarHostSate The state of the snackbar host.
 * @param navController The navigation controller for navigating between composables.
 * @param scope The coroutine scope for managing coroutines in the application.
 */
@Immutable
data class NavigationContext(
    val snackbarHostSate: SnackbarHostState,
    val navController: NavHostController,
    val navigationState: NavigationState,
    val scope: CoroutineScope
)

/**
 * Composable function to remember the application context, providing access to essential components
 * like navigation controller, coroutine scope, and context.
 *
 * @return An instance of [NavigationContext] containing the essential components.
 */
@Stable
@Composable
fun rememberNavigationContext(navigationState: NavigationState): NavigationContext {
    val snackbarHostSate = remember { SnackbarHostState() }
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    return remember(navController) {
        NavigationContext(
            snackbarHostSate = snackbarHostSate,
            navigationState = navigationState,
            navController = navController,
            scope = scope
        )
    }
}