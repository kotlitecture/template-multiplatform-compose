package shared.presentation.theme

import androidx.compose.ui.text.font.FontFamily

/**
 * Represents the configuration for theming in the application.
 *
 * @param defaultTheme The initial theme data provider to be used by default.
 * @param autoDark Whether to enable automatic dark mode based on system settings.
 * @param darkTheme The default dark theme to be used.
 * @param lightTheme The default light theme to be used.
 * @param fontFamily The default font family to be used in the application.
 */
data class ThemeConfig(
    val defaultTheme: Theme,
    val autoDark: Boolean = true,
    val darkTheme: Theme = defaultTheme,
    val lightTheme: Theme = defaultTheme,
    val fontFamily: FontFamily = FontFamily.Default
)