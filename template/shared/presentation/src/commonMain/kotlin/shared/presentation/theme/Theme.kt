package shared.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf

internal val localTheme = staticCompositionLocalOf<Theme?> { null }

@Stable
interface Theme {
    val id: String
    val dark: Boolean
    val colorScheme: ColorScheme
}