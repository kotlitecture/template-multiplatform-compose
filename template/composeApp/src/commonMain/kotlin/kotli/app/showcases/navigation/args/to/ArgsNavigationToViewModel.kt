package kotli.app.showcases.navigation.args.to

import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class ArgsNavigationToViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
