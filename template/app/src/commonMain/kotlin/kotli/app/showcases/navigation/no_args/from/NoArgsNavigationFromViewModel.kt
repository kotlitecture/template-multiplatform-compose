package kotli.app.showcases.navigation.no_args.from

import kotli.app.showcases.navigation.no_args.to.NoArgsNavigationToDestination
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState

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
