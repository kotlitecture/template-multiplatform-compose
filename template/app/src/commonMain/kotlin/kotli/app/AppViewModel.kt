package kotli.app

import kotli.app.feature.showcases.ShowcasesRoute
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(
    private val _state: AppMutableState
) : BaseViewModel() {

    val state: AppState = _state

    override fun doBind() = async("Init start destination") {
        _state.startDestination = ShowcasesRoute
    }
}