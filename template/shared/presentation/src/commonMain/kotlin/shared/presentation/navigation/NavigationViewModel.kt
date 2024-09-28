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
        launchAsync("Remember current destination") {
            context.navController.currentBackStackEntryFlow
                .mapNotNull { entry -> entry.destination.route }
                .mapNotNull(NavigationDestination.Companion::getByRoute)
                .distinctUntilChanged()
                .collectLatest { destination ->
                    val state = navigationState.currentDestinationState
                    if (state.isNull()) {
                        context.scope.launch { state.set(destination) }
                    } else {
                        state.set(destination)
                    }
                }
        }
    }

    fun onUnbind(navigationState: NavigationStore) {
        navigationState.commandHandler = NavigationCommandHandler.create()
    }

}