package kotli.app.feature.passcode.reset.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.common.domain.usecase.CheckPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.common.domain.usecase.ResetPasscodeUseCase
import org.jetbrains.compose.resources.getString
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
                if (checkPasscode.invoke(enteredCode) == LockState.UNLOCKED) {
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

    private class ResetPasscodeMutableState(
        override val passcodeLength: Int
    ) : ResetPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
        override var enteredCode: String by mutableStateOf("")
        override var event: ResetPasscodeEvent? by mutableStateOf(null)
    }
}
