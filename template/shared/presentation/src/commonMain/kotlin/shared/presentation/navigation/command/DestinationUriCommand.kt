package shared.presentation.navigation.command

import shared.presentation.navigation.NavigationCommand
import shared.presentation.navigation.NavigationContext
import shared.presentation.navigation.NavigationStrategy

/**
 * Represents a navigation command to navigate to a destination URI.
 *
 * @property uriString The Uri string of the destination.
 * @property strategy The navigation strategy to use.
 */
data class DestinationUriCommand(
    val uriString: String,
    val strategy: NavigationStrategy,
) : NavigationCommand() {

    override val id: String = "destination_uri"

    override fun doExecute(navigationContext: NavigationContext) {
        try {
            val controller = navigationContext.navController
            strategy.proceed(null, uriString, controller)
        } catch (e: Exception) {
            navigationContext.navigationStore.error(id, e)
        }
    }

}