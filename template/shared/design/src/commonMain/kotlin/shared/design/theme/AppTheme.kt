package shared.design.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import shared.presentation.theme.ThemeContext

/**
 * Application theme context.
 */
@Immutable
data class AppTheme(
    override val id: String,
    override val dark: Boolean,
    val colorScheme: ColorScheme
) : ThemeContext() {

    val error: Color = colorScheme.error
    val surface: Color = colorScheme.surface
    val onSurface: Color = colorScheme.onSurface

    val highlightPrimary:Color = colorScheme.onSurface.copy(alpha = 0.15f)
    val highlightSecondary:Color = colorScheme.onSurface.copy(alpha = 0.1f)

    val topBlur by lazy {
        Brush.verticalGradient(
            listOf(
                surface,
                surface.copy(alpha = 0.95f),
                surface.copy(alpha = 0.9f),
                surface.copy(alpha = 0.85f),
            )
        )
    }

    val bottomBlur by lazy {
        Brush.verticalGradient(
            listOf(
                surface.copy(alpha = 0.85f),
                surface.copy(alpha = 0.9f),
                surface.copy(alpha = 0.95f),
                surface
            )
        )
    }

    @Composable
    override fun apply(fontFamily: FontFamily, content: @Composable () -> Unit) {
        MaterialTheme(
            typography = remember(fontFamily) { map(fontFamily) },
            colorScheme = colorScheme,
            content = content
        )
    }

    private fun map(fontFamily: FontFamily): Typography {
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

    companion object {
        /** Returns the current App theme data in the composition. */
        val current: AppTheme
            @Composable
            @ReadOnlyComposable
            get() = ThemeContext.current as AppTheme
    }

}