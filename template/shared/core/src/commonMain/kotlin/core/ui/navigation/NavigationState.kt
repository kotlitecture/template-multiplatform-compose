package core.ui.navigation

import core.ui.navigation.command.DestinationCommand
import core.ui.navigation.command.DestinationUriCommand
import core.ui.state.StoreObject
import core.ui.state.StoreState

/**
 * Represents the navigation state of the application, managing the destination and navigation data.
 *
 * This class extends [StoreState], providing mechanisms for managing the current navigation state.
 *
 * @param destinations A list of navigation destinations available in the application.
 */
class NavigationState(
    val destinations: List<NavigationDestination<*>>
) : StoreState() {

    /** StoreObject to hold the initial navigation destination. */
    val startDestinationStore: StoreObject<NavigationDestination<*>> = StoreObject()

    /** StoreObject to hold the current navigation destination. */
    val currentDestinationStore: StoreObject<NavigationDestination<*>> = StoreObject()

    /** StoreObject to hold the current navigation data. */
    internal var commandHandler: NavigationCommandHandler = NavigationCommandHandler.create()

    /**
     * Sets the start destination for navigation.
     *
     * @param startDestination The start destination to be set.
     */
    fun setStartDestination(startDestination: NavigationDestination<*>) {
        startDestinationStore.set(startDestination)
    }

    /**
     * Executes any command related to navigation.
     *
     * @param command The command to execute.
     */
    fun onCommand(command: NavigationCommand) {
        commandHandler.handle(command)
    }

    /**
     * Navigate back to the previous screen.
     */
    fun onBack() {
        onCommand(
            DestinationCommand(
                strategy = NavigationStrategy.Back,
                destination = null,
                data = null,
            )
        )
    }

    /**
     * Navigate to a new destination with optional data and strategy.
     *
     * @param destination The destination to navigate to.
     * @param data The optional data to pass during navigation.
     * @param strategy The navigation strategy to use. Defaults to the destination's default strategy.
     */
    fun <D> onNext(
        destination: NavigationDestination<D>,
        data: D? = null,
        strategy: NavigationStrategy = destination.navStrategy
    ) {
        onCommand(
            DestinationCommand(
                destination = destination,
                strategy = strategy,
                data = data
            )
        )
    }

    /**
     * Navigates to the specified URI using the provided navigation strategy.
     *
     * @param uriString The Uri string of the destination.
     * @param strategy The navigation strategy to use.
     */
    fun onNext(
        uriString: String,
        strategy: NavigationStrategy
    ) {
        onCommand(
            DestinationUriCommand(
                uriString = uriString,
                strategy = strategy
            )
        )
    }

}