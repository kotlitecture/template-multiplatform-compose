package shared.presentation.navigation

import shared.presentation.navigation.command.DestinationCommand
import shared.presentation.navigation.command.DestinationUriCommand
import shared.presentation.store.DataState
import shared.presentation.store.Store

/**
 * Represents the navigation store of the application, managing the destination and navigation data.
 *
 * This class extends [Store], providing mechanisms for managing the current navigation state.
 *
 * @param destinations A list of navigation destinations available in the application.
 */
class NavigationStore(
    val destinations: List<NavigationDestination<*>>
) : Store() {

    /** DataState to hold the initial navigation destination. */
    val startDestinationState: DataState<NavigationDestination<*>> = DataState()

    /** DataState to hold the current navigation destination. */
    val currentDestinationState: DataState<NavigationDestination<*>> = DataState()

    /** DataState to hold the current navigation data. */
    internal var commandHandler: NavigationCommandHandler = NavigationCommandHandler.create()

    /**
     * Sets the start destination for navigation.
     *
     * @param startDestination The start destination to be set.
     */
    fun setStartDestination(startDestination: NavigationDestination<*>) {
        startDestinationState.set(startDestination)
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
     * Executes any command related to navigation.
     *
     * @param command The command to execute.
     */
    private fun onCommand(command: NavigationCommand) {
        commandHandler.handle(command)
    }
}