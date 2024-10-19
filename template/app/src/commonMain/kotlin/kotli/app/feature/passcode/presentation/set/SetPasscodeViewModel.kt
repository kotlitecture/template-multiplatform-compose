package kotli.app.feature.passcode.presentation.set

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.usecase.CheckPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.domain.usecase.IsPasscodeSetUseCase
import kotli.app.feature.passcode.domain.usecase.SetPasscodeUseCase
import org.jetbrains.compose.resources.getString
import shared.presentation.viewmodel.BaseViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_set_confirm_new_error
import template.app.generated.resources.passcode_unlock_error

class SetPasscodeViewModel(
    getPasscodeLength: GetPasscodeLengthUseCase,
    private val setPasscode: SetPasscodeUseCase,
    private val isPasscodeSet: IsPasscodeSetUseCase,
    private val checkPasscode: CheckPasscodeUseCase,
    private val getAttempts: GetRemainingAttemptsUseCase,
) : BaseViewModel() {

    private val _state = SetPasscodeMutableState(getPasscodeLength.invoke())
    val state: SetPasscodeState = _state

    override fun doBind() = async("Init state") {
        val step = if (isPasscodeSet.invoke()) {
            SetPasscodeStep.UnlockExisting()
        } else {
            SetPasscodeStep.EnterNew()
        }
        Snapshot.withMutableSnapshot {
            _state.enteredCode = ""
            _state.loading = false
            _state.error = null
            _state.step = step
        }
    }

    fun onEnter(enteredCode: String) {
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
                    is SetPasscodeStep.ConfirmNew -> onConfirmNew(step.code, enteredCode)
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
        if (checkPasscode.invoke(enteredCode) == LockState.LOCKED) {
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
        enteredCode: String
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
            _state.event = SetPasscodeEvent.Complete
        }
    }

    private class SetPasscodeMutableState(
        override val passcodeLength: Int
    ) : SetPasscodeState {
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
        override var enteredCode: String by mutableStateOf("")
        override var step: SetPasscodeStep? by mutableStateOf(null)
        override var event: SetPasscodeEvent? by mutableStateOf(null)
    }
}
