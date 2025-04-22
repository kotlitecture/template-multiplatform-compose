package kotli.app.auth.signout.presentation

import androidx.compose.runtime.Stable
import shared.presentation.state.UiEvent
import shared.presentation.state.ViewState

@Stable
interface SignOutState : ViewState {

    object OnSuccess : UiEvent
}