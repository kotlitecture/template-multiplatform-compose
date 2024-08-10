package kotli.app.presentation.passcode.ui.set.confirm

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.SetPasscode
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

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

    fun onConfirm(expectedCode: String, enteredCode: String, errorText: String) {
        enteredCodeState.set(enteredCode)

        if (enteredCode.isNotEmpty()) {
            errorStore.clear()
        }

        if (enteredCode.length != expectedCode.length) {
            return
        }

        if (enteredCode != expectedCode) {
            errorStore.set(errorText)
            enteredCodeState.clear()
            return
        }

        launchAsync("Set passcode", passcodeStore) {
            setPasscode.invoke(enteredCode)
            onBack()
        }
    }
}
