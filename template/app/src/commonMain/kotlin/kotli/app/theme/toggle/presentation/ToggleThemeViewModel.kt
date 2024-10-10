package kotli.app.theme.toggle.presentation

import shared.presentation.theme.ThemeMutableState
import shared.presentation.viewmodel.BaseViewModel

class ToggleThemeViewModel(
    private val themeState: ThemeMutableState
) : BaseViewModel() {

    val state = ToggleThemeState(themeState)

    fun onToggle() {
        val dark = state.isDark() ?: return

        if (dark) {
            themeState.setLight()
        } else {
            themeState.setDark()
        }
    }
}
