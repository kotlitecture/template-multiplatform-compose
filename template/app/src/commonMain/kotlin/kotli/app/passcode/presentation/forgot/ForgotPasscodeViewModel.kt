package kotli.app.passcode.presentation.forgot

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.passcode.domain.usecase.ForgotPasscodeUseCase
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
            withState {
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
