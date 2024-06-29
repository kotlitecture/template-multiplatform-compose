package kotli.app.showcases.navigation.args.from

import kotli.app.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

class ArgsNavigationFromViewModel(
    private val navigationState: NavigationStore,
) : BaseViewModel() {

    val userNameState = DataState<String>()

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigate() {
        navigationState.onNext(
            destination = ArgsNavigationToDestination,
            data = ArgsNavigationToDestination.Data(
                userName = userNameState.get()
            )
        )
    }

}
