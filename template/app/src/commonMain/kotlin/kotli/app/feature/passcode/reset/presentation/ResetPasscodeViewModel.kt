package kotli.app.feature.passcode.reset.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.common.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.common.domain.usecase.ResetPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.UnlockPasscodeUseCase
import org.jetbrains.compose.resources.getString
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_error

class ResetPasscodeViewModel(
    private val resetPasscode: ResetPasscodeUseCase,
    private val unlockPasscode: UnlockPasscodeUseCase,
    private val getAttempts: GetRemainingAttemptsUseCase,
    private val getPasscodeLength: GetPasscodeLengthUseCase
) : BaseViewModel() {

    private val _state = ResetPasscodeMutableState()
    val state: ResetPasscodeState = _state

    override fun doBind() = ui("Init state") {
        val length = getPasscodeLength.invoke()
        Snapshot.withMutableSnapshot {
            _state.passcodeLength = length
            _state.enteredCode = ""
            _state.loading = false
            _state.error = null
        }
    }

    fun onReset(enteredCode: String) {
        if (_state.passcodeLength == 0) return

        Snapshot.withMutableSnapshot {
            _state.enteredCode = enteredCode
            _state.error = null
        }

        if (enteredCode.length != _state.passcodeLength) return

        async("Reset passcode", force = true) {
            try {
                _state.loading = true
                if (unlockPasscode.invoke(enteredCode) == LockState.UNLOCKED) {
                    resetPasscode.invoke()
                    _state.event = ResetPasscodeEvent.Complete
                } else {
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

    private class ResetPasscodeMutableState : ResetPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
        override var enteredCode: String by mutableStateOf("")
        override var passcodeLength: Int by mutableStateOf(0)
        override var event: ResetPasscodeEvent? by mutableStateOf(null)
    }
}
