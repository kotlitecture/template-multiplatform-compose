package kotli.app.showcases.navigation.no_args.from

import kotli.app.showcases.navigation.no_args.to.NoArgsNavigationToDestination
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class NoArgsNavigationFromViewModel(
    private val navigationState: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigate() {
        navigationState.onNext(NoArgsNavigationToDestination)
    }

}
