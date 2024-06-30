package kotli.app.presentation.theme

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.theme.ThemeStore

class AppThemeViewModel(
    val themeStore: ThemeStore
) : BaseViewModel() {

    override fun doBind() {
        themeStore.configState.set(themeStore.defaultConfig)
    }

}