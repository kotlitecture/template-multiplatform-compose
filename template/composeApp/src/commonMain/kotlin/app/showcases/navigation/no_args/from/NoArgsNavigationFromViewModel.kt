package app.showcases.navigation.no_args.from

import app.showcases.navigation.no_args.to.NoArgsNavigationToDestination
import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class NoArgsNavigationFromViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigate() {
        navigationState.onNext(NoArgsNavigationToDestination)
    }

}
