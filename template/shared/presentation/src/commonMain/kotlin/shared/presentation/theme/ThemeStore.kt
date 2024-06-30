package shared.presentation.theme

import shared.presentation.store.DataState
import shared.presentation.store.Store

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
 */
data class ThemeStore(
    val persistentKey: String = "theme_config",
    val defaultConfig: ThemeConfig,
    val dynamicConfig: ThemeConfig? = null,
    val availableThemes: List<ThemeContext> = emptyList(),
) : Store() {

    private val contextById by lazy {
        val themes = availableThemes.associateBy { it.id }.toMutableMap()
        themes[defaultConfig.defaultTheme.id] = defaultConfig.defaultTheme
        themes[defaultConfig.lightTheme.id] = defaultConfig.lightTheme
        themes[defaultConfig.darkTheme.id] = defaultConfig.darkTheme
        dynamicConfig?.lightTheme?.let { themes[it.id] = it }
        dynamicConfig?.darkTheme?.let { themes[it.id] = it }
        themes
    }

    /** State of the font family. */
    val configState = DataState<ThemeConfig>()

    /** State of the theme dark mode. */
    val systemDarkModeState = DataState<Boolean>()

    /** State of the current theme context. */
    val dataState = DataState<ThemeData>()

    /**
     * Finds a theme provider by its ID.
     *
     * @param id The ID of the theme provider to find.
     * @return The theme provider with the specified ID, or null if not found.
     */
    fun getById(id: String?): ThemeContext? {
        return contextById[id]
    }

    /**
     * Sets the theme to light mode.
     */
    fun setLight() {
        val config = configState.get() ?: defaultConfig
        configState.set(
            config.copy(
                autoDark = false,
                defaultTheme = config.lightTheme
            )
        )
    }

    /**
     * Sets the theme to dark mode.
     */
    fun setDark() {
        val config = configState.get() ?: defaultConfig
        configState.set(
            config.copy(
                autoDark = false,
                defaultTheme = config.darkTheme
            )
        )
    }

    /**
     * Sets the theme to auto mode.
     */
    fun setAuto() {
        val config = configState.get() ?: defaultConfig
        configState.set(config.copy(autoDark = true))
    }

}