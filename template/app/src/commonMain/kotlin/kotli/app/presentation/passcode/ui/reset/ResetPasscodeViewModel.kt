package kotli.app.presentation.passcode.ui.reset

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.ResetPasscode
import org.jetbrains.compose.resources.getString
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class ResetPasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val resetPasscode: ResetPasscode,
    private val passcodeStore: PasscodeStore
) : BaseViewModel() {

    val passcodeLength = passcodeStore.passcodeLength
    val enteredCodeState = DataState<String>()
    val errorStore = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        enteredCodeState.clear()
    }

    fun onReset(enteredCode: String) {
        enteredCodeState.set(enteredCode)
        errorStore.clear()

        if (enteredCode.length != passcodeLength) {
            return
        }

        launchAsync("Reset passcode", passcodeStore) {
            if(resetPasscode.invoke(enteredCode)) {
                navigationStore.onBack()
            } else {
                val error = getString(Res.string.passcode_unlock_error)
                enteredCodeState.clear()
                errorStore.set(error)
            }
        }
    }
}
