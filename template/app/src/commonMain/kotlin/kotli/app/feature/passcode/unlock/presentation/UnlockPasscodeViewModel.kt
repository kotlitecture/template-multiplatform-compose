package kotli.app.feature.passcode.unlock.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.common.domain.LockState
import kotli.app.feature.passcode.unlock.domain.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.unlock.domain.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.common.domain.UnlockPasscodeUseCase
import org.jetbrains.compose.resources.getString
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class UnlockPasscodeViewModel(
    private val unlockPasscode: UnlockPasscodeUseCase,
    private val getAttempts: GetRemainingAttemptsUseCase,
    private val getPasscodeLength: GetPasscodeLengthUseCase
) : BaseViewModel() {

    private val _state = UnlockPasscodeMutableState()
    val state: UnlockPasscodeState = _state

    override fun doBind() = ui("Init state") {
        val length = getPasscodeLength.invoke()
        Snapshot.withMutableSnapshot {
            _state.passcodeLength = length
            _state.enteredCode = ""
            _state.loading = false
            _state.error = null
        }
    }

    fun onForgot() {
        _state.forgot = true
    }

    fun onCancelForgot() {
        _state.forgot = false
    }

    fun onUnlock(enteredCode: String) {
        if (_state.passcodeLength == 0) return

        Snapshot.withMutableSnapshot {
            _state.enteredCode = enteredCode
            _state.error = null
        }

        if (enteredCode.length != _state.passcodeLength) return

        async("Unlock passcode", force = true) {
            try {
                _state.loading = true
                val lockState = unlockPasscode.invoke(enteredCode)
                if (lockState == LockState.LOCKED) {
                    val attempts = getAttempts.invoke()
                    val error = getString(Res.string.passcode_unlock_error, attempts)
                    Snapshot.withMutableSnapshot {
                        _state.enteredCode = ""
                        _state.loading = false
                        _state.error = error
                    }
                }
            } finally {
                _state.loading = false
            }
        }
    }

    private class UnlockPasscodeMutableState : UnlockPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var forgot: Boolean by mutableStateOf(false)
        override var loading: Boolean by mutableStateOf(false)
        override var enteredCode: String by mutableStateOf("")
        override var passcodeLength: Int by mutableStateOf(0)
    }
}
