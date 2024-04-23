package core.ui.theme.material3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import core.ui.theme.ThemeConfig
import core.ui.theme.ThemeDataProvider

/**
 * Data class representing a Material3 theme data provider.
 *
 * @property dark Indicates whether the theme is dark mode or not.
 * @property colorScheme The color scheme used in the theme.
 */
data class Material3ThemeDataProvider(
    override val id: String,
    override val dark: Boolean,
    val colorScheme: ColorScheme
) : ThemeDataProvider<Material3ThemeData>() {

    override fun provide(config: ThemeConfig): Material3ThemeData {
        return Material3ThemeData(
            typography = createTypography(config.fontFamily),
            fontFamily = config.fontFamily,
            colorScheme = colorScheme,
            provider = this,
        )
    }

    /**
     * Creates typography settings for the given font family.
     *
     * @param fontFamily The font family to be used in typography.
     * @return Typography settings with the specified font family.
     */
    private fun createTypography(fontFamily: FontFamily): Typography {
        val typography = Typography()
        if (typography.bodyLarge.fontFamily != fontFamily) {
            return Typography(
                displayLarge = typography.displayLarge.copy(fontFamily = fontFamily),
                displayMedium = typography.displayMedium.copy(fontFamily = fontFamily),
                displaySmall = typography.displaySmall.copy(fontFamily = fontFamily),
                headlineLarge = typography.headlineLarge.copy(fontFamily = fontFamily),
                headlineMedium = typography.headlineMedium.copy(fontFamily = fontFamily),
                headlineSmall = typography.headlineSmall.copy(fontFamily = fontFamily),
                titleLarge = typography.titleLarge.copy(fontFamily = fontFamily),
                titleMedium = typography.titleMedium.copy(fontFamily = fontFamily),
                titleSmall = typography.titleSmall.copy(fontFamily = fontFamily),
                bodyLarge = typography.bodyLarge.copy(fontFamily = fontFamily),
                bodyMedium = typography.bodyMedium.copy(fontFamily = fontFamily),
                bodySmall = typography.bodySmall.copy(fontFamily = fontFamily),
                labelLarge = typography.labelLarge.copy(fontFamily = fontFamily),
                labelMedium = typography.labelMedium.copy(fontFamily = fontFamily),
                labelSmall = typography.labelSmall.copy(fontFamily = fontFamily)
            )
        } else {
            return typography
        }
    }

}