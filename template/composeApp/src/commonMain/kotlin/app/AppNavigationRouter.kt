package app

import app.showcases.ShowcasesDestination
import core.ui.navigation.NavigationDestination

/**
 * ViewModel-scoped class representing the application navigation router.
 */
class AppNavigationRouter() {

    /**
     * Returns the start destination based on the current passcode status.
     *
     * @return The start destination.
     */
    suspend fun getStartDestination(): NavigationDestination<*> {
        return ShowcasesDestination
    }

}