package kotli.app.passcode.presentation.reset

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.passcode.domain.model.LockState
import kotli.app.passcode.domain.usecase.CheckPasscodeUseCase
import kotli.app.passcode.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.passcode.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.passcode.domain.usecase.ResetPasscodeUseCase
import org.jetbrains.compose.resources.getString
import shared.presentation.state.MutableViewState
import shared.presentation.state.UiState
import shared.presentation.state.notify
import shared.presentation.state.tryCatch
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class ResetPasscodeViewModel(
    getPasscodeLength: GetPasscodeLengthUseCase,
    private val resetPasscode: ResetPasscodeUseCase,
    private val checkPasscode: CheckPasscodeUseCase,
    private val getAttempts: GetRemainingAttemptsUseCase,
) : BaseViewModel() {

    private val _state = ResetPasscodeMutableState(getPasscodeLength.invoke())
    val state: ResetPasscodeState = _state

    fun onReset(code: String) {
        if (_state.passcodeLength == 0) return

        withState {
            _state.enteredCode = code
            _state.error = null
        }

        if (code.length != _state.passcodeLength) return

        async("onReset", force = true) {
            _state.tryCatch(
                title = "Reset passcode",
                onTry = {
                    withState { uiState = UiState.Blocking }
                    if (checkPasscode.invoke(code) == LockState.UNLOCKED) {
                        resetPasscode.invoke()
                        _state.notify(ResetPasscodeState.OnComplete)
                        withState { uiState = UiState.Ready }
                    } else {
                        val attempts = getAttempts.invoke()
                        val unlockError = getString(Res.string.passcode_unlock_error, attempts)
                        withState {
                            enteredCode = ""
                            error = unlockError
                            uiState = UiState.Ready
                        }
                    }
                }
            )
        }
    }

    private class ResetPasscodeMutableState(
        override val passcodeLength: Int
    ) : MutableViewState(), ResetPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var enteredCode: String by mutableStateOf("")
    }
}
