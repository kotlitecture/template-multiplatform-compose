package app.ui.theme

import shared.core.BaseViewModel
import shared.core.theme.ThemeState

class AppThemeViewModel(
    val themeState: ThemeState
) : BaseViewModel() {

    override fun doBind() {
        themeState.configStore.set(themeState.defaultConfig)
    }

}