package kotli.app.feature.passcode.ui.reset

import kotli.app.feature.passcode.model.LockState
import kotli.app.feature.passcode.model.PasscodeStore
import kotli.app.feature.passcode.usecase.ResetPasscode
import kotli.app.feature.passcode.usecase.UnlockPasscode
import org.jetbrains.compose.resources.getString
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class ResetPasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val unlockPasscode: UnlockPasscode,
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

        async("Reset passcode") {
            if (unlockPasscode.invoke(enteredCode) == LockState.UNLOCKED) {
                resetPasscode.invoke()
                navigationStore.onBack()
            } else {
                val attempts = passcodeStore.getRemainingUnlockAttempts()
                val error = getString(Res.string.passcode_unlock_error, attempts)
                enteredCodeState.clear()
                errorStore.set(error)
            }
        }
    }
}
