package kotli.app.showcases.navigation.no_args.to

import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState

class NoArgsNavigationToViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigation() {

    }

}
