package core.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navigationState: NavigationState,
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
        navigationState = navigationState,
        navigationContext = navigationContext
    )
}