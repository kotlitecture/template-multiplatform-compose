package kotli.app.passcode.presentation.reset

import androidx.compose.runtime.Stable

@Stable
interface ResetPasscodeState {

    val error: String?
    val loading: Boolean
    val enteredCode: String
    val passcodeLength: Int
    val event: ResetPasscodeEvent?

}