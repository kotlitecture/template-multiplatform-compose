package kotli.app.presentation.showcases.navigation.args.from

import kotli.app.presentation.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

class ArgsNavigationFromViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    val userNameState = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    fun onNavigate() {
        navigationStore.onNext(
            destination = ArgsNavigationToDestination,
            data = ArgsNavigationToDestination.Data(
                userName = userNameState.get()
            )
        )
    }

}
