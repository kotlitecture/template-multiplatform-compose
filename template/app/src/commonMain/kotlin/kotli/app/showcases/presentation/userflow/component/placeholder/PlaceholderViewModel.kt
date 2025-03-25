package kotli.app.showcases.presentation.userflow.component.placeholder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import shared.presentation.viewmodel.BaseViewModel

class PlaceholderViewModel : BaseViewModel() {

    private val _state = PlaceholderMutableState()
    val state: PlaceholderState = _state

    fun onShow() = async("Show placeholder") {
        _state.loading = true
        delay(3000L)
        _state.loading = false
    }

    private class PlaceholderMutableState : PlaceholderState {
        override var loading: Boolean by mutableStateOf(false)
    }

}
