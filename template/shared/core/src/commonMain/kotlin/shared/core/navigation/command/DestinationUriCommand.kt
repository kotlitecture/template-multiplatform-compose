package shared.core.navigation.command

import shared.core.navigation.NavigationCommand
import shared.core.navigation.NavigationContext
import shared.core.navigation.NavigationStrategy
import shared.core.state.DataState

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
            val dataState = DataState.Error(id, e)
            val navigationState = navigationContext.navigationState
            navigationState.dataStateStore.set(dataState)
        }
    }

}