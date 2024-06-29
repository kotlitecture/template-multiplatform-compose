package kotli.app.ui.theme

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.theme.ThemeStore

class AppThemeViewModel(
    val themeState: ThemeStore
) : BaseViewModel() {

    override fun doBind() {
        themeState.configState.set(themeState.defaultConfig)
    }

}