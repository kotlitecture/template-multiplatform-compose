package shared.presentation.navigation

/**
 * Interface for handling navigation commands.
 */
fun interface NavigationCommandHandler {

    /**
     * Handles the given navigation command.
     *
     * @param command The navigation command to handle.
     */
    fun handle(command: NavigationCommand)

    companion object {
        fun create(context: NavigationContext? = null) = NavigationCommandHandler { command ->
            context?.let(command::execute)
        }
    }
}