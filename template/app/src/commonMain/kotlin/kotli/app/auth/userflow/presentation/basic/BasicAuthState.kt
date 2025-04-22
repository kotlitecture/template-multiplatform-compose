package kotli.app.auth.userflow.presentation.basic

import androidx.compose.runtime.Stable
import kotli.app.auth.common.domain.model.AuthUser
import shared.presentation.state.ViewState

@Stable
interface BasicAuthState : ViewState {

    val authUser: AuthUser?
}