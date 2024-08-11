package kotli.app.presentation.passcode.ui.set.confirm

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.SetPasscode
import org.jetbrains.compose.resources.getString
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_confirm_error

class ConfirmPasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val passcodeStore: PasscodeStore,
    private val setPasscode: SetPasscode,
) : BaseViewModel() {

    val enteredCodeState = DataState<String>()
    val errorStore = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        enteredCodeState.clear()
    }

    fun onConfirm(expectedCode: String, enteredCode: String) {
        enteredCodeState.set(enteredCode)

        if (enteredCode.isNotEmpty()) {
            errorStore.clear()
        }

        if (enteredCode.length != expectedCode.length) {
            return
        }

        launchAsync("Set passcode", passcodeStore) {
            if (enteredCode != expectedCode) {
                val error = getString(Res.string.passcode_confirm_error)
                enteredCodeState.clear()
                errorStore.set(error)
            } else {
                setPasscode.invoke(enteredCode)
                onBack()
            }
        }
    }
}
