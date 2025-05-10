package shared.presentation.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily

@Stable
interface ThemeState {
    val defaultConfig: ThemeConfig
    val dynamicConfig: ThemeConfig?
    val availableThemes: List<Theme>

    var currentConfig: ThemeConfig?
    var systemDarkMode: Boolean?
    var fontFamily: FontFamily
    var currentTheme: Theme?

    fun getById(id: String?): Theme?

    fun setLight()

    fun setDark()

    fun setAuto()
}

data class DefaultThemeState(
    override val defaultConfig: ThemeConfig,
    override val dynamicConfig: ThemeConfig? = null,
    override val availableThemes: List<Theme> = emptyList(),
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

    override fun setLight() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(
            autoDark = false,
            defaultTheme = config.lightTheme
        )
    }

    override fun setDark() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(
            autoDark = false,
            defaultTheme = config.darkTheme
        )
    }

    override fun setAuto() {
        val config = currentConfig ?: defaultConfig
        currentConfig = config.copy(autoDark = true)
    }
}