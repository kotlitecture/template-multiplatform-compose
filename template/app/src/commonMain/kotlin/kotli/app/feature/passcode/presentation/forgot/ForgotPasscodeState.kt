package kotli.app.feature.passcode.presentation.forgot

import androidx.compose.runtime.Stable

@Stable
interface ForgotPasscodeState {

    val loading: Boolean
    val event: ForgotPasscodeEvent?

}