package kotli.app.showcases.navigation.args.to

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class ArgsNavigationToViewModel(
    private val navigationState: NavigationStore,
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
