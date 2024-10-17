package shared.presentation.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
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