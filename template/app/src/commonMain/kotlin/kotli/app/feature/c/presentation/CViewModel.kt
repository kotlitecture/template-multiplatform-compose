package kotli.app.feature.c.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.presentation.viewmodel.BaseViewModel

class CViewModel : BaseViewModel() {

    private val _state = CMutableState()
    val state: CState = _state

    private class CMutableState : CState {
        override var title: String by mutableStateOf("C")
    }

}
