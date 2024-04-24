package core.ui.theme.material3

import core.ui.theme.ThemeDataProvider

/**
 * Object containing functions to generate Material3 theme data providers for different theme variations.
 */
object Material3Themes {

    /**
     * Generates a dark Material3 theme data provider.
     *
     * @return A theme data provider for the dark theme.
     */
    fun dark(): ThemeDataProvider<*> {
        return Material3ThemeDataProvider(
            id = "material_3_dark",
            dark = true,
            colorScheme = DarkColors
        )
    }

    /**
     * Generates a light Material3 theme data provider.
     *
     * @return A theme data provider for the light theme.
     */
    fun light(): ThemeDataProvider<*> {
        return Material3ThemeDataProvider(
            id = "material_3_light",
            dark = false,
            colorScheme = LightColors
        )
    }

}
