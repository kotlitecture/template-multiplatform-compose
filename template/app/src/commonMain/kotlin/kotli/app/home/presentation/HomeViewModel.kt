package kotli.app.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.presentation.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val _state = HomeMutableState()
    val state: HomeState = _state

    private class HomeMutableState : HomeState {
        override var title: String by mutableStateOf("Home")
    }

}
