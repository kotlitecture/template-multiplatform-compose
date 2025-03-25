package shared.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal val localTheme = staticCompositionLocalOf<Theme?> { null }

@Immutable
data class Theme(
    val id: String,
    val dark: Boolean,
    val colorScheme: ColorScheme
) {

    val error: Color = colorScheme.error
    val surface: Color = colorScheme.surface
    val onSurface: Color = colorScheme.onSurface

    val highlightPrimary: Color = colorScheme.onSurface.copy(alpha = 0.15f)
    val highlightSecondary: Color = colorScheme.onSurface.copy(alpha = 0.1f)

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

    companion object {
        val current: Theme
            @Composable
            @ReadOnlyComposable
            get() = localTheme.current ?: error("not available outside of ThemeProvider")
    }

}