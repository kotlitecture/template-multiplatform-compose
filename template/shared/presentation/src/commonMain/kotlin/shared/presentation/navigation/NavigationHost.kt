package shared.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

/**
 * Composable function that sets up a navigation host.
 *
 * This function configures the navigation host using the provided state, context, and start destination.
 * It also applies transitions for entering and exiting destinations.
 *
 * @param modifier The modifier to be applied to the navigation host. Defaults to [Modifier].
 * @param navigationState The state containing navigation destinations and their bindings.
 * @param navigationContext The context providing navigation-related dependencies, such as the navController.
 * @param startDestination The starting destination for the navigation host.
 */
@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navigationState: NavigationStore,
    navigationContext: NavigationContext,
    startDestination: NavigationDestination<*>
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        startDestination = startDestination.route,
        navController = navigationContext.navController,
        enterTransition = { fadeIn(animationSpec = tween(100)) },
        exitTransition = { fadeOut(animationSpec = tween(100)) },
        builder = { navigationState.destinations.forEach { it.bind(this) } }
    )
    NavigationProvider(
        navigationStore = navigationState,
        navigationContext = navigationContext
    )
}