package kotli.app.showcases.navigation.args.to

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class ArgsNavigationToViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

}
