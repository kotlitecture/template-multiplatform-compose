package kotli.app.presentation.passcode.ui.set

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.IsPasscodeSet
import kotli.app.presentation.passcode.usecase.SetPasscode
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import org.jetbrains.compose.resources.getString
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_set_confirm_new_error
import template.app.generated.resources.passcode_unlock_error

class SetPasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val unlockPasscode: UnlockPasscode,
    private val isPasscodeSet: IsPasscodeSet,
    private val passcodeStore: PasscodeStore,
    private val setPasscode: SetPasscode,
) : BaseViewModel() {

    val passcodeLength = passcodeStore.passcodeLength

    val uiState = DataState<SetPasscodeState>()
    val enteredCodeState = DataState<String>()
    val errorStore = DataState<String>()

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        launchAsync("Init state") {
            enteredCodeState.clear()
            if (isPasscodeSet.invoke()) {
                uiState.set(SetPasscodeState.UnlockExisting())
            } else {
                uiState.set(SetPasscodeState.EnterNew())
            }
        }
    }

    fun onEnter(enteredCode: String) {
        enteredCodeState.set(enteredCode)
        errorStore.clear()

        if (enteredCode.length != passcodeLength) {
            return
        }

        launchAsync("Check passcode") {
            when (val state = uiState.get()) {
                is SetPasscodeState.ConfirmNew -> onConfirmNew(state.code, enteredCode)
                is SetPasscodeState.UnlockExisting -> onUnlockExisting(enteredCode)
                is SetPasscodeState.EnterNew -> onEnterNew(enteredCode)
                else -> Unit
            }
        }
    }

    private suspend fun onUnlockExisting(enteredCode: String) {
        if (unlockPasscode.invoke(enteredCode) == LockState.LOCKED) {
            val attempts = passcodeStore.getRemainingUnlockAttempts()
            errorStore.set(getString(Res.string.passcode_unlock_error, attempts))
            enteredCodeState.clear()
        } else {
            uiState.set(SetPasscodeState.EnterNew())
            enteredCodeState.clear()
        }
    }

    private fun onEnterNew(enteredCode: String) {
        uiState.set(SetPasscodeState.ConfirmNew(code = enteredCode))
        enteredCodeState.clear()
    }

    private suspend fun onConfirmNew(expectedCode: String, enteredCode: String) {
        if (enteredCode != expectedCode) {
            errorStore.set(getString(Res.string.passcode_set_confirm_new_error))
            uiState.set(SetPasscodeState.EnterNew())
            enteredCodeState.clear()
        } else {
            setPasscode.invoke(enteredCode)
            onBack()
        }
    }
}
