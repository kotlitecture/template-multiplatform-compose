package shared.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

/**
 * Represents the configuration for theming in the application.
 *
 * @param autoDark Whether to enable automatic dark mode based on system settings.
 * @param defaultTheme The initial theme data provider to be used by default.
 * @param darkTheme The default dark theme to be used.
 * @param lightTheme The default light theme to be used.
 * @param fontFamily The default font family to be used in the application.
 */
@Immutable
data class ThemeConfig(
    val autoDark: Boolean = true,
    val defaultTheme: ThemeContext,
    val darkTheme: ThemeContext = defaultTheme,
    val lightTheme: ThemeContext = defaultTheme,
    val fontFamily: FontFamily = FontFamily.Default
)