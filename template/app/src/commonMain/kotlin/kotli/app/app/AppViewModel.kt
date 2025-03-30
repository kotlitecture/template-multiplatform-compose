package kotli.app.app

import kotli.app.showcases.presentation.ShowcasesRoute
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(
    private val _state: AppMutableState
) : BaseViewModel() {

    val state: AppState = _state

    override fun doBind() {
        _state.startDestination = ShowcasesRoute
    }
}