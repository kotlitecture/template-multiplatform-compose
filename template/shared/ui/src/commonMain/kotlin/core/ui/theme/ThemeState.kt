package core.ui.theme

import core.ui.state.StoreObject
import core.ui.state.StoreState

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
data class ThemeState(
    val persistentKey: String? = "theme_config",
    val defaultConfig: ThemeConfig,
    val dynamicConfig: ThemeConfig? = null,
    val availableThemes: List<ThemeDataProvider<*>> = emptyList(),
) : StoreState() {

    private val themeById by lazy {
        val themes = availableThemes.associateBy { it.id }.toMutableMap()
        themes[defaultConfig.defaultTheme.id] = defaultConfig.defaultTheme
        themes[defaultConfig.lightTheme.id] = defaultConfig.lightTheme
        themes[defaultConfig.darkTheme.id] = defaultConfig.darkTheme
        dynamicConfig?.lightTheme?.let { themes[it.id] = it }
        dynamicConfig?.darkTheme?.let { themes[it.id] = it }
        themes
    }

    /** Store object for the font family. */
    val configStore = StoreObject<ThemeConfig>()

    /** Store object for the theme dark mode state. */
    val systemDarkModeStore = StoreObject<Boolean>()

    /** Store object for the current theme data. */
    val dataStore = StoreObject<ThemeData>()

    /**
     * Finds a theme provider by its ID.
     *
     * @param id The ID of the theme provider to find.
     * @return The theme provider with the specified ID, or null if not found.
     */
    fun findProviderById(id: String?): ThemeDataProvider<*>? {
        return themeById[id]
    }

    /**
     * Sets the theme to light mode.
     */
    fun setLight() {
        val config = configStore.get() ?: defaultConfig
        configStore.set(
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
        val config = configStore.get() ?: defaultConfig
        configStore.set(
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
        val config = configStore.get() ?: defaultConfig
        configStore.set(config.copy(autoDark = true))
    }

}