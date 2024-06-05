package shared.presentation.navigation

import androidx.navigation.NavHostController
import androidx.navigation.navOptions

/**
 * Enumeration representing various navigation strategies used in navigating between destinations.
 */
enum class NavigationStrategy {
    /**
     * Strategy to navigate back to the previous screen.
     */
    Back {
        override fun doProceed(route: String?, uriString: String, controller: NavHostController) {
            if (controller.previousBackStackEntry != null) {
                controller.popBackStack()
            }
        }
    },

    /**
     * Strategy to create a new instance of the destination and navigate to it.
     */
    NewInstance {
        override fun doProceed(route: String?, uriString: String, controller: NavHostController) {
            controller.navigate(uriString)
        }
    },

    /**
     * Strategy to use a single instance of the destination and navigate to it.
     */
    SingleInstance {
        override fun doProceed(route: String?, uriString: String, controller: NavHostController) {
            controller.navigate(uriString, navOptions {
                if (route != null) {
                    popUpTo(route) {
                        inclusive = true
                    }
                }
                launchSingleTop = true
                restoreState = false
            })
        }
    },

    /**
     * Strategy to replace the previous destination with a new one and navigate to it.
     */
    ReplacePrevious {
        override fun doProceed(route: String?, uriString: String, controller: NavHostController) {
            val prev = controller.currentDestination?.route ?: route
            controller.navigate(uriString, navOptions {
                if (prev != null) {
                    popUpTo(prev) {
                        inclusive = true
                    }
                }
                launchSingleTop = true
                restoreState = false
            })
        }
    },

    /**
     * Strategy to clear the navigation history and navigate to the specified destination.
     */
    ClearHistory {
        override fun doProceed(route: String?, uriString: String, controller: NavHostController) {
            controller.navigate(uriString, navOptions {
                controller.graph.route?.let { graphRoute ->
                    popUpTo(graphRoute) {
                        inclusive = true
                    }
                }
            })
        }
    }

    ;

    /**
     * Method to execute the navigation strategy.
     *
     * @param route The route of the destination.
     * @param uriString The URI string of the destination.
     * @param controller The NavController used for navigation.
     */
    internal fun proceed(route: String?, uriString: String, controller: NavHostController) {
        val currentRoute = controller.currentDestination?.route
        if (uriString.isNotEmpty() || currentRoute != route) {
            doProceed(route, uriString, controller)
        }
    }

    protected open fun doProceed(route: String?, uriString: String, controller: NavHostController) = Unit
}