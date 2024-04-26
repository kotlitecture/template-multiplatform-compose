package app.ui.navigation

import androidx.compose.runtime.Composable
import app.ui.navigation.adaptive.AdaptiveNavigation

/**
 * Composable function to provide navigation functionality.
 *
 */
@Composable
fun NavigationBarProvider(content: @Composable () -> Unit) {
    AdaptiveNavigation(content)
}