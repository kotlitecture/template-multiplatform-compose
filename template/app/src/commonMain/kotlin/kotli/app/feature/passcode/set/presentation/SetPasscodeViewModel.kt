package kotli.app.feature.passcode.set.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.common.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.common.domain.usecase.IsPasscodeSetUseCase
import kotli.app.feature.passcode.common.domain.usecase.SetPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.UnlockPasscodeUseCase
import org.jetbrains.compose.resources.getString
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_set_confirm_new_error
import template.app.generated.resources.passcode_unlock_error

class SetPasscodeViewModel(
    private val setPasscode: SetPasscodeUseCase,
    private val isPasscodeSet: IsPasscodeSetUseCase,
    private val unlockPasscode: UnlockPasscodeUseCase,
    private val getAttempts: GetRemainingAttemptsUseCase,
    private val getPasscodeLength: GetPasscodeLengthUseCase
) : BaseViewModel() {

    private val _state = SetPasscodeMutableState()
    val state: SetPasscodeState = _state

    override fun doBind() = async("Init state") {
        val length = getPasscodeLength.invoke()
        val state = if (isPasscodeSet.invoke()) {
            SetPasscodeStep.UnlockExisting()
        } else {
            SetPasscodeStep.EnterNew()
        }
        Snapshot.withMutableSnapshot {
            _state.passcodeLength = length
            _state.enteredCode = ""
            _state.loading = false
            _state.error = null
            _state.step = state
        }
    }

    fun onEnter(enteredCode: String, onComplete: () -> Unit) {
        if (_state.passcodeLength == 0) return

        Snapshot.withMutableSnapshot {
            _state.enteredCode = enteredCode
            _state.error = null
        }

        if (enteredCode.length != _state.passcodeLength) return

        async("Check passcode", force = true) {
            try {
                _state.loading = true
                when (val step = _state.step) {
                    is SetPasscodeStep.ConfirmNew -> onConfirmNew(
                        step.code,
                        enteredCode,
                        onComplete
                    )

                    is SetPasscodeStep.UnlockExisting -> onUnlockExisting(enteredCode)
                    is SetPasscodeStep.EnterNew -> onEnterNew(enteredCode)
                    else -> Unit
                }
            } finally {
                _state.loading = false
            }
        }
    }

    private suspend fun onUnlockExisting(enteredCode: String) {
        if (unlockPasscode.invoke(enteredCode) == LockState.LOCKED) {
            val attempts = getAttempts.invoke()
            val error = getString(Res.string.passcode_unlock_error, attempts)
            Snapshot.withMutableSnapshot {
                _state.enteredCode = ""
                _state.loading = false
                _state.error = error
            }
        } else {
            Snapshot.withMutableSnapshot {
                _state.step = SetPasscodeStep.EnterNew()
                _state.enteredCode = ""
                _state.loading = false
            }
        }
    }

    private fun onEnterNew(enteredCode: String) {
        Snapshot.withMutableSnapshot {
            _state.step = SetPasscodeStep.ConfirmNew(code = enteredCode)
            _state.enteredCode = ""
            _state.loading = false
        }
    }

    private suspend fun onConfirmNew(
        expectedCode: String,
        enteredCode: String,
        onComplete: () -> Unit
    ) {
        if (enteredCode != expectedCode) {
            Snapshot.withMutableSnapshot {
                _state.error = getString(Res.string.passcode_set_confirm_new_error)
                _state.step = SetPasscodeStep.EnterNew()
                _state.enteredCode = ""
                _state.loading = false
            }
        } else {
            setPasscode.invoke(enteredCode)
            onComplete()
        }
    }

    private class SetPasscodeMutableState : SetPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
        override var enteredCode: String by mutableStateOf("")
        override var passcodeLength: Int by mutableStateOf(0)
        override var step: SetPasscodeStep? by mutableStateOf(null)
    }
}
