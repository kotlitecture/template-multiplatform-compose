package core.ui.navigation.command

import core.ui.navigation.NavigationCommand
import core.ui.navigation.NavigationContext
import core.ui.navigation.NavigationStrategy
import core.ui.state.DataState

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