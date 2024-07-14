package shared.presentation.navigation

import androidx.compose.runtime.Immutable
import kotlinx.coroutines.launch

/**
 * Abstract class representing a command involving UI.
 *
 * Commands encapsulate logic to be executed within the application.
 * Each command has a unique identifier.
 * To execute a command, call the execute method passing the command state and application context.
 * Subclasses must implement the doExecute method to define the specific behavior of the command.
 */
@Immutable
abstract class NavigationCommand {

    abstract val id: String

    /**
     * Executes the command.
     *
     * @param navigationContext The application context providing necessary resources for command execution.
     */
    fun execute(navigationContext: NavigationContext) {
        navigationContext.scope.launch {
            try {
                doExecute(navigationContext)
            } catch (e: Exception) {
                navigationContext.navigationStore.error(id, e)
            }
        }
    }

    protected abstract fun doExecute(navigationContext: NavigationContext)

}