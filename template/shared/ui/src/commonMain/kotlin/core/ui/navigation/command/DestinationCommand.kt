package core.ui.navigation.command

import core.ui.navigation.NavigationCommand
import core.ui.navigation.NavigationContext
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy
import core.ui.state.DataState

/**
 * Represents a command to navigate to a specific destination with optional data and strategy.
 *
 * @param destination The destination to navigate to.
 * @param strategy The navigation strategy to use.
 * @param data The optional data to pass during navigation.
 */
data class DestinationCommand<D>(
    val destination: NavigationDestination<D>?,
    val strategy: NavigationStrategy,
    val data: D?,
) : NavigationCommand() {

    override val id: String = destination?.id ?: "back_destination"

    override fun doExecute(navigationContext: NavigationContext) {
        try {
            val controller = navigationContext.navController
            if (destination != null) {
                destination.navigate(data, strategy, controller)
            } else {
                strategy.proceed(null, "", controller)
            }
        } catch (e: Exception) {
            val dataState = DataState.Error(id, e)
            val navigationState = navigationContext.navigationState
            navigationState.dataStateStore.set(dataState)
        }
    }

}