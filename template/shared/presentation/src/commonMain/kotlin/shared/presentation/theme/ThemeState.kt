package shared.presentation.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontFamily

@Stable
interface ThemeState {
    val persistentKey: String
    val defaultConfig: ThemeConfig
    val dynamicConfig: ThemeConfig?
    val availableThemes: List<Theme>

    val currentConfig: ThemeConfig?
    val systemDarkMode: Boolean?
    val fontFamily: FontFamily
    val currentTheme: Theme?

    fun getById(id: String?): Theme?
}