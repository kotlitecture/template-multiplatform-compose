package kotli.app.navigation.a.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.presentation.viewmodel.BaseViewModel

class AViewModel : BaseViewModel() {

    private val _state = AMutableState()
    val state: AState = _state

    private class AMutableState : AState {
        override var title: String by mutableStateOf("A")
    }

}
