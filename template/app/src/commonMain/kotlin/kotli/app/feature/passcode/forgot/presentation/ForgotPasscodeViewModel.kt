package kotli.app.feature.passcode.forgot.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.feature.passcode.common.domain.usecase.ForgotPasscodeUseCase
import shared.presentation.viewmodel.BaseViewModel

class ForgotPasscodeViewModel(
    private val forgotPasscode: ForgotPasscodeUseCase
) : BaseViewModel() {

    private val _state = ForgotPasscodeMutableState()
    val state: ForgotPasscodeState = _state

    fun onConfirm() = async("Reset passcode") {
        try {
            _state.loading = true
            forgotPasscode.invoke()
        } finally {
            Snapshot.withMutableSnapshot {
                _state.event = ForgotPasscodeEvent.Complete
                _state.loading = false
            }
        }
    }

    private class ForgotPasscodeMutableState : ForgotPasscodeState {
        override var loading: Boolean by mutableStateOf(false)
        override var event: ForgotPasscodeEvent? by mutableStateOf(null)
    }

}
