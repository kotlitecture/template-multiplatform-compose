package app.ui.theme

import core.ui.BaseViewModel
import core.ui.theme.ThemeState

class AppThemeViewModel(
    val themeState: ThemeState
) : BaseViewModel() {

    override fun doBind() {
        themeState.configStore.set(themeState.defaultConfig)
    }

}