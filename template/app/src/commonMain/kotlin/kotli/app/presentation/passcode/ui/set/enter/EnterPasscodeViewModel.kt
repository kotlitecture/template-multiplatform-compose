package kotli.app.presentation.passcode.ui.set.enter

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.ui.set.confirm.ConfirmPasscodeDestination
import shared.presentation.navigation.NavigationStore
import shared.presentation.navigation.NavigationStrategy
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class EnterPasscodeViewModel(
    private val navigationStore: NavigationStore,
    passcodeStore: PasscodeStore
) : BaseViewModel() {

    val passcodeLength = passcodeStore.passcodeLength
    val enteredCodeState = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        enteredCodeState.clear()
    }

    fun onEnter(enteredCode: String) {
        enteredCodeState.set(enteredCode)

        if (enteredCode.length == passcodeLength) {
            navigationStore.onNext(
                destination = ConfirmPasscodeDestination,
                strategy = NavigationStrategy.ReplacePrevious,
                data = ConfirmPasscodeDestination.Data(enteredCode)
            )
        }
    }
}
