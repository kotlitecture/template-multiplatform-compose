package shared.presentation.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontFamily

/**
 * Represents the state of the theme settings within the application.
 * This state includes the font family, available theme providers, and the current theme provider.
 *
 * @property persistentKey If the configuration needs to be automatically saved across app restarts,
 * this property represents the key of the value in the key-value storage.
 * A null value indicates that the configuration is not persistent.
 * @property defaultConfig the default config to use.
 * @property dynamicConfig the dynamic config to use if such can be provided.
 * @property availableThemes The list of all available theme data providers.
 * @property currentConfig The currently selected config.
 * @property currentTheme The currently selected theme.
 * @property systemDarkMode The current dark mode state.
 * @property fontFamily The selected font family.
 */
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