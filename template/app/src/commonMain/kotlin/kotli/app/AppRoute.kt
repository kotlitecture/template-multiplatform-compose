package kotli.app

import androidx.navigation.NavHostController
import androidx.navigation.navOptions

interface AppRoute

fun NavHostController.back() {
    if (previousBackStackEntry != null) {
        popBackStack()
    }
}

fun NavHostController.newInstance(route: Any) {
    navigate(route)
}

fun NavHostController.singleInstance(route: Any) {
    navigate(route, navOptions {
        popUpTo(route) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = false
    })
}

fun NavHostController.replacePrevious(route: Any) {
    val prev = currentDestination?.route ?: route
    navigate(route, navOptions {
        popUpTo(prev) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = false
    })
}

fun NavHostController.clearHistory(route: Any) {
    navigate(route, navOptions {
        graph.route?.let { graphRoute ->
            popUpTo(graphRoute) {
                inclusive = true
            }
        }
    })
}