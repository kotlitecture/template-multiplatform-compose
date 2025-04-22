package kotli.app.auth.userflow.presentation.basic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.auth.common.domain.model.AuthUser
import kotli.app.auth.common.domain.usecase.GetAuthUseCase
import shared.presentation.state.MutableViewState
import shared.presentation.state.UiState
import shared.presentation.viewmodel.BaseViewModel

class BasicAuthViewModel(
    private val getAuth: GetAuthUseCase
) : BaseViewModel() {

    private val _state = BasicAuthMutableState()
    val state: BasicAuthState = _state

    override fun doBind() = async("doBind") {
        getAuth.invoke().collect { user ->
            withState {
                _state.authUser = user
                _state.uiState = UiState.Ready
            }
        }
    }

    private class BasicAuthMutableState : MutableViewState(UiState.Loading), BasicAuthState {
        override var authUser: AuthUser? by mutableStateOf(null)
    }
}
