package kotli.app.passcode.presentation.reset

import androidx.compose.runtime.Stable
import shared.presentation.state.UiEvent
import shared.presentation.state.ViewState

@Stable
interface ResetPasscodeState : ViewState {

    val error: String?
    val enteredCode: String
    val passcodeLength: Int

    object OnComplete : UiEvent
}