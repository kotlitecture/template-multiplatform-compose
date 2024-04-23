package core.ui.theme.material3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import core.ui.theme.ThemeData

/**
 * Data class representing Material3 theme data.
 *
 * @property fontFamily The font family used in the theme.
 * @property provider The theme data provider.
 * @property colorScheme The color scheme used in the theme.
 * @property typography The typography settings used in the theme.
 */
@Immutable
data class Material3ThemeData(
    override val fontFamily: FontFamily,
    val provider: Material3ThemeDataProvider,
    val colorScheme: ColorScheme,
    val typography: Typography,
) : ThemeData() {

    override val dark: Boolean = provider.dark
    override val providerId: String = provider.id
    override val primary: Color = colorScheme.surface
    override val onPrimary: Color = colorScheme.onSurface

    companion object {
        /** Returns the current Material3 theme data in the composition. */
        val current: Material3ThemeData
            @Composable
            @ReadOnlyComposable
            get() = ThemeData.current as Material3ThemeData
    }

}