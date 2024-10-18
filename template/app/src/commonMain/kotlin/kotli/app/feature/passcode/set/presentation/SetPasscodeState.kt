package kotli.app.feature.passcode.set.presentation

import androidx.compose.runtime.Stable

@Stable
interface SetPasscodeState {

    val error: String?
    val loading: Boolean
    val enteredCode: String
    val passcodeLength: Int
    val step: SetPasscodeStep?
    val event: SetPasscodeEvent?

}