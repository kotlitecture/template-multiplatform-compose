package kotli.app.presentation.showcases.navigation.no_args.to

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class NoArgsNavigationToViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

    fun onNavigation() {

    }

}
