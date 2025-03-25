package kotli.app.theme.provide.presentation

import shared.presentation.theme.ThemeState
import shared.presentation.viewmodel.BaseViewModel

class ThemeStatelessViewModel(val state: ThemeState) : BaseViewModel() {

    init {
        state.currentConfig = state.defaultConfig
    }
}