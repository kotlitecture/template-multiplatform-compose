package kotli.app.feature.passcode.unlock.presentation

import androidx.compose.runtime.Stable

@Stable
interface UnlockPasscodeState {

    val error: String?
    val forgot: Boolean
    val loading: Boolean
    val enteredCode: String
    val passcodeLength: Int

}