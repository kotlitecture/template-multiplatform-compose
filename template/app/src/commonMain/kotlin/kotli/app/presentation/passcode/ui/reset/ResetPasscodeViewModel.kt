package kotli.app.presentation.passcode.ui.reset

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.ResetPasscode
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class ResetPasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val resetPasscode: ResetPasscode,
    private val passcodeStore: PasscodeStore
) : BaseViewModel() {

    val passcodeLength = passcodeStore.passcodeLength
    val enteredCodeState = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        enteredCodeState.clear()
    }

    fun onReset(enteredCode: String) {
        enteredCodeState.set(enteredCode)

        if (enteredCode.length != passcodeLength) {
            return
        }

        launchAsync("Reset passcode", passcodeStore) {
            try {
                resetPasscode.invoke(enteredCode)
                navigationStore.onBack()
            } catch (e: Exception) {
                enteredCodeState.clear()
            }
        }
    }
}
