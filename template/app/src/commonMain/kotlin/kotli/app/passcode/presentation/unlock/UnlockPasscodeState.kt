package kotli.app.passcode.presentation.unlock

import androidx.compose.runtime.Stable
import shared.presentation.state.ViewState

@Stable
interface UnlockPasscodeState : ViewState {

    val error: String?
    val forgot: Boolean
    val enteredCode: String
    val passcodeLength: Int
}