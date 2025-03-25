package shared.presentation.navigation

import androidx.navigation.NavHostController
import androidx.navigation.navOptions

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
        graph.startDestinationRoute?.let { graphRoute ->
            popUpTo(graphRoute) {
                inclusive = false
            }
        }
    })
}