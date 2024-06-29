package kotli.app.showcases.navigation.args.from

import kotli.app.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.store.DataState

class ArgsNavigationFromViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    val userNameStore = DataState<String>()

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigate() {
        navigationState.onNext(
            destination = ArgsNavigationToDestination,
            data = ArgsNavigationToDestination.Data(
                userName = userNameStore.get()
            )
        )
    }

}
