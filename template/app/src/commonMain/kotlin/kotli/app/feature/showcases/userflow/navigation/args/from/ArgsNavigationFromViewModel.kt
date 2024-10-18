package kotli.app.feature.showcases.userflow.navigation.args.from

import androidx.compose.runtime.mutableStateOf
import kotli.app.feature.showcases.userflow.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class ArgsNavigationFromViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    val userNameState = mutableStateOf("")

    fun onBack() {
        navigationStore.onBack()
    }

    fun onNavigate() {
        navigationStore.onNext(
            destination = ArgsNavigationToDestination,
            data = ArgsNavigationToDestination.Data(
                userName = userNameState.value
            )
        )
    }

}
