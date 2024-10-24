package kotli.app.feature.showcases.presentation.userflow.loader.advanced

import kotli.app.common.presentation.loader.LoaderState
import kotli.app.common.presentation.loader.create
import kotlinx.coroutines.delay
import shared.presentation.viewmodel.BaseViewModel

class AdvancedLoaderViewModel : BaseViewModel() {

    private val _state = AdvancedLoaderMutableState()
    val state: AdvancedLoaderState = _state

    fun onShow() = async("Show loader") {
        _state.loaderState.runCatching("Advanced loader") {
            delay(1000L)
            throw IllegalStateException("Some caught error.")
        }
    }

    private class AdvancedLoaderMutableState : AdvancedLoaderState {
        override val loaderState: LoaderState = LoaderState.create()
    }

}
