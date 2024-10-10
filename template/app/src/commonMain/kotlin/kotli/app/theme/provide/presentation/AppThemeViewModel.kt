package kotli.app.theme.provide.presentation

import shared.presentation.theme.ThemeMutableState
import shared.presentation.viewmodel.BaseViewModel

class AppThemeViewModel(val state: ThemeMutableState) : BaseViewModel() {

    init {
        state.currentConfig = state.defaultConfig
    }
}