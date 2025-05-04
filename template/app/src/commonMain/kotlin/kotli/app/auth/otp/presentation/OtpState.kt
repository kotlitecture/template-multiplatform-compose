package kotli.app.auth.otp.presentation

import androidx.compose.runtime.Stable
import shared.presentation.state.UiEvent
import shared.presentation.state.ViewState

@Stable
interface OtpState : ViewState {

    val otp: String
    val canVerify: Boolean

    object OnSuccess : UiEvent
}
