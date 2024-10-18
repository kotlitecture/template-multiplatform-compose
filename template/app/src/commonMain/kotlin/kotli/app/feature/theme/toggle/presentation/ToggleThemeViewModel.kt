package kotli.app.feature.theme.toggle.presentation

import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.theme.ThemeMutableState
import shared.presentation.theme.ThemeState
import shared.presentation.viewmodel.BaseViewModel

class ToggleThemeViewModel(
    private val themeState: ThemeMutableState
) : BaseViewModel() {

    private val _state = ToggleThemeMutableState(themeState)
    val state: ToggleThemeState = _state

    fun onToggle() {
        val dark = _state.isDark() ?: return

        if (dark) {
            themeState.setLight()
        } else {
            themeState.setDark()
        }
    }

    private data class ToggleThemeMutableState(
        private val themeState: ThemeState
    ) : ToggleThemeState {

        override fun isDark(): Boolean? {
            return themeState.currentTheme?.dark
        }

        override fun getIcon(): AppIconModel? {
            val theme = themeState.currentTheme

            return when {
                theme == null -> null
                theme.dark -> AppIcons.lightMode
                else -> AppIcons.darkMode
            }
        }
    }
}
