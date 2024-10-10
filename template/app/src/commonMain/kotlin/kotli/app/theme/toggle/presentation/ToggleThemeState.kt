package kotli.app.theme.toggle.presentation

import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.theme.ThemeState

data class ToggleThemeState(private val themeState: ThemeState) {

    fun isDark(): Boolean? {
        return themeState.currentTheme?.dark
    }

    fun getIcon(): AppIconModel? {
        val theme = themeState.currentTheme

        return when {
            theme == null -> null
            theme.dark -> AppIcons.lightMode
            else -> AppIcons.darkMode
        }
    }
}