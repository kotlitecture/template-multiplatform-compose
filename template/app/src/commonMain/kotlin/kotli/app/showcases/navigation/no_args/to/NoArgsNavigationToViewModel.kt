package kotli.app.showcases.navigation.no_args.to

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class NoArgsNavigationToViewModel(
    private val navigationState: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigation() {

    }

}
