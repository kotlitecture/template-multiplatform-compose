package kotli.app.feature.theme.provide.presentation

import shared.presentation.theme.ThemeState
import shared.presentation.viewmodel.BaseViewModel

class ThemeViewModel(val state: ThemeState) : BaseViewModel() {

    init {
        state.currentConfig = state.defaultConfig
    }
}