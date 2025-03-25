package kotli.app.navigation.b.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.presentation.viewmodel.BaseViewModel

class BViewModel : BaseViewModel() {

    private val _state = BMutableState()
    val state: BState = _state

    private class BMutableState : BState {
        override var title: String by mutableStateOf("B")
    }

}
