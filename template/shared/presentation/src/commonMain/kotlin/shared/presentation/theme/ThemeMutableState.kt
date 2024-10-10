package shared.presentation.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily

data class ThemeMutableState(
    override val persistentKey: String = "theme_config",
    override val availableThemes: List<Theme> = emptyList(),
    override val dynamicConfig: ThemeConfig? = null,
    override val defaultConfig: ThemeConfig,
) : ThemeState {

    private val byId by lazy {
        val themes = availableThemes.associateBy { theme -> theme.id }.toMutableMap()
        dynamicConfig?.lightTheme?.let { theme -> themes[theme.id] = theme }
        dynamicConfig?.darkTheme?.let { theme -> themes[theme.id] = theme }
        themes[defaultConfig.defaultTheme.id] = defaultConfig.defaultTheme
        themes[defaultConfig.lightTheme.id] = defaultConfig.lightTheme
        themes[defaultConfig.darkTheme.id] = defaultConfig.darkTheme
        themes
    }

    override var fontFamily: FontFamily by mutableStateOf(defaultConfig.fontFamily)
    override var currentConfig: ThemeConfig? by mutableStateOf(null)
    override var systemDarkMode: Boolean? by mutableStateOf(null)
    override var currentTheme: Theme? by mutableStateOf(null)

    override fun getById(id: String?): Theme? = byId[id]

    /**
     * Sets the theme to light mode.
     */
    fun setLight() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(
            autoDark = false,
            defaultTheme = config.lightTheme
        )
    }

    /**
     * Sets the theme to dark mode.
     */
    fun setDark() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(
            autoDark = false,
            defaultTheme = config.darkTheme
        )
    }

    /**
     * Sets the theme to auto mode.
     */
    fun setAuto() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(autoDark = true)
    }
}
