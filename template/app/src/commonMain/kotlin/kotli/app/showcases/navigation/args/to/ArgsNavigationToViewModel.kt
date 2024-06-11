package kotli.app.showcases.navigation.args.to

import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState

class ArgsNavigationToViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
