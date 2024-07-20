package shared.presentation.navigation

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import shared.presentation.viewmodel.BaseViewModel

/**
 * ViewModel responsible for managing navigation-related functionality.
 */
class NavigationViewModel : BaseViewModel() {

    fun onBind(navigationState: NavigationStore, context: NavigationContext) {
        navigationState.commandHandler = NavigationCommandHandler.create(context)
        launchAsync("currentDestinationStore") {
            context.navController.currentBackStackEntryFlow
                .mapNotNull { entry -> entry.destination.route }
                .mapNotNull(NavigationDestination.Companion::getByRoute)
                .distinctUntilChanged()
                .collectLatest { destination ->
                    val store = navigationState.currentDestinationState
                    if (store.isNull()) {
                        context.scope.launch { store.set(destination) }
                    } else {
                        store.set(destination)
                    }
                }
        }
    }

    fun onUnbind(navigationState: NavigationStore) {
        navigationState.commandHandler = NavigationCommandHandler.create()
    }

}