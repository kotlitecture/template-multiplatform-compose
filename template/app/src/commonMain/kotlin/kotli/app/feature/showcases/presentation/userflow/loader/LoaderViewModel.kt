package kotli.app.feature.showcases.presentation.userflow.loader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import shared.presentation.viewmodel.BaseViewModel

class LoaderViewModel : BaseViewModel() {

    private val _state = LoaderMutableState()
    val state: LoaderState = _state

    fun onShow() = async("Show loader") {
        _state.loading = true
        delay(3000L)
        _state.loading = false
    }

    private class LoaderMutableState : LoaderState {
        override var loading: Boolean by mutableStateOf(false)
    }

}
