package core.ui.navigation

import core.ui.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for managing navigation-related functionality.
 */
class NavigationViewModel : BaseViewModel() {

    fun onBind(navigationState: NavigationState, context: NavigationContext) {
        navigationState.commandHandler = NavigationCommandHandler.create(context)
        launchAsync("currentDestinationStore") {
            context.navController.currentBackStackEntryFlow
                .mapNotNull { it.destination.route }
                .mapNotNull(NavigationDestination.Companion::getByRoute)
                .distinctUntilChanged()
                .collectLatest {
                    val store = navigationState.currentDestinationStore
                    if (store.isNull()) {
                        context.scope.launch { store.set(it) }
                    } else {
                        store.set(it)
                    }
                }
        }
    }

    fun onUnbind(navigationState: NavigationState) {
        navigationState.commandHandler = NavigationCommandHandler.create()
    }

}