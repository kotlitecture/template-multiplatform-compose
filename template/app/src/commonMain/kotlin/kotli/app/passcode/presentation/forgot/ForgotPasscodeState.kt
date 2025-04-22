package kotli.app.passcode.presentation.forgot

import androidx.compose.runtime.Stable
import shared.presentation.state.UiEvent
import shared.presentation.state.ViewState

@Stable
interface ForgotPasscodeState : ViewState {

    object OnComplete : UiEvent
}