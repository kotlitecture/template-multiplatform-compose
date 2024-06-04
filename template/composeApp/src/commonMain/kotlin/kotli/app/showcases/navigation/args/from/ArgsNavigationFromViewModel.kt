package kotli.app.showcases.navigation.args.from

import kotli.app.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

class ArgsNavigationFromViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    val userNameStore = StoreObject<String>()

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
