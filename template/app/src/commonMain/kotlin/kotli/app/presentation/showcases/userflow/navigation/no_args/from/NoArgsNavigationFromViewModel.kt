package kotli.app.presentation.showcases.userflow.navigation.no_args.from

import kotli.app.presentation.showcases.userflow.navigation.no_args.to.NoArgsNavigationToDestination
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class NoArgsNavigationFromViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

    fun onNavigate() {
        navigationStore.onNext(NoArgsNavigationToDestination)
    }

}
