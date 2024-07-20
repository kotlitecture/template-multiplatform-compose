package shared.presentation.navigation.command

import shared.presentation.navigation.NavigationCommand
import shared.presentation.navigation.NavigationContext
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationStrategy

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
            navigationContext.navigationStore.error(id, e)
        }
    }

}