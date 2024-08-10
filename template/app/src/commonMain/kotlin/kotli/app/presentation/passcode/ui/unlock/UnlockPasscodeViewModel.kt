package kotli.app.presentation.passcode.ui.unlock

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

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

        if (enteredCode.length != passcodeLength) {
            return
        }

        launchAsync("Unlock passcode", passcodeStore) {
            val lock = unlockPasscode.invoke(enteredCode)
            if (lock == LockState.LOCKED) {
                enteredCodeState.clear()
            }
        }
    }
}