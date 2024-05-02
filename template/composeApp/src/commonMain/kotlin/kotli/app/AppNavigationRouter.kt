package kotli.app

import kotli.app.showcases.ShowcasesDestination
import shared.core.navigation.NavigationDestination

/**
 * Application navigation router.
 */
class AppNavigationRouter {

    /**
     * Returns the start destination based on the current application state.
     *
     * @return The start destination.
     */
    suspend fun getStartDestination(): NavigationDestination<*> {
        return ShowcasesDestination
    }

}