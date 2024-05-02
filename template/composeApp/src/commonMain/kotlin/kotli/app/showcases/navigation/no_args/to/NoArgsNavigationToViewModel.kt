package kotli.app.showcases.navigation.no_args.to

import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class NoArgsNavigationToViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigation() {

    }

}
