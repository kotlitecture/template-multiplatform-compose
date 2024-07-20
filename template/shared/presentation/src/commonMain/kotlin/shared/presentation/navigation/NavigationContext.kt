package shared.presentation.navigation

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
 */
@Immutable
data class NavigationContext(
    val navController: NavHostController,
    val navigationStore: NavigationStore,
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
fun rememberNavigationContext(navigationState: NavigationStore): NavigationContext {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    return remember(navigationState, navController, scope) {
        NavigationContext(
            navigationStore = navigationState,
            navController = navController,
            scope = scope
        )
    }
}