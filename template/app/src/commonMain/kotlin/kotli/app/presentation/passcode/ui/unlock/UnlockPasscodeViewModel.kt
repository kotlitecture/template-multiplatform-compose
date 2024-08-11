package kotli.app.presentation.passcode.ui.unlock

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import org.jetbrains.compose.resources.getString
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class UnlockPasscodeViewModel(
    private val unlockPasscode: UnlockPasscode,
    private val passcodeStore: PasscodeStore,
) : BaseViewModel() {

    val passcodeLength = passcodeStore.passcodeLength
    val enteredCodeState = DataState<String>()
    val forgotState = DataState<Boolean>()
    val errorStore = DataState<String>()

    override fun doBind() {
        enteredCodeState.clear()
    }

    fun onForgot() {
        forgotState.set(true)
    }

    fun onUnlock(enteredCode: String) {
        enteredCodeState.set(enteredCode)
        errorStore.clear()

        if (enteredCode.length != passcodeLength) {
            return
        }

        launchAsync("Unlock passcode", passcodeStore) {
            val lock = unlockPasscode.invoke(enteredCode)
            if (lock == LockState.LOCKED) {
                val error = getString(Res.string.passcode_unlock_error)
                enteredCodeState.clear()
                errorStore.set(error)
            }
        }
    }
}
