package kotli.app.passcode.presentation.set

import androidx.compose.runtime.Stable
import shared.presentation.state.UiEvent
import shared.presentation.state.ViewState

@Stable
interface SetPasscodeState : ViewState {

    val error: String?
    val enteredCode: String
    val passcodeLength: Int
    val step: SetPasscodeStep?

    object OnComplete : UiEvent
}