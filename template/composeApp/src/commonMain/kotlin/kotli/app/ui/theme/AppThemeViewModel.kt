package kotli.app.ui.theme

import shared.presentation.BaseViewModel
import shared.presentation.theme.ThemeState

class AppThemeViewModel(
    val themeState: ThemeState
) : BaseViewModel() {

    override fun doBind() {
        themeState.configStore.set(themeState.defaultConfig)
    }

}