package core.ui.theme.material3

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import core.ui.theme.ThemeDataProvider

internal val DarkGreen10 = Color(0xFF0D1F12)
internal val DarkGreen20 = Color(0xFF223526)
internal val DarkGreen30 = Color(0xFF394B3C)
internal val DarkGreen40 = Color(0xFF4F6352)
internal val DarkGreen80 = Color(0xFFB7CCB8)
internal val DarkGreen90 = Color(0xFFD3E8D3)
internal val DarkGreenGray10 = Color(0xFF1A1C1A)
internal val DarkGreenGray20 = Color(0xFF2F312E)
internal val DarkGreenGray90 = Color(0xFFE2E3DE)
internal val DarkGreenGray95 = Color(0xFFF0F1EC)
internal val DarkGreenGray99 = Color(0xFFFBFDF7)
internal val Green10 = Color(0xFF00210B)
internal val Green20 = Color(0xFF003919)
internal val Green30 = Color(0xFF005227)
internal val Green40 = Color(0xFF006D36)
internal val Green80 = Color(0xFF0EE37C)
internal val Green90 = Color(0xFF5AFF9D)
internal val GreenGray30 = Color(0xFF414941)
internal val GreenGray50 = Color(0xFF727971)
internal val GreenGray60 = Color(0xFF8B938A)
internal val GreenGray80 = Color(0xFFC1C9BF)
internal val GreenGray90 = Color(0xFFDDE5DB)
internal val Red10 = Color(0xFF410002)
internal val Red20 = Color(0xFF690005)
internal val Red30 = Color(0xFF93000A)
internal val Red40 = Color(0xFFBA1A1A)
internal val Red80 = Color(0xFFFFB4AB)
internal val Red90 = Color(0xFFFFDAD6)
internal val Teal10 = Color(0xFF001F26)
internal val Teal20 = Color(0xFF02363F)
internal val Teal30 = Color(0xFF214D56)
internal val Teal40 = Color(0xFF3A656F)
internal val Teal80 = Color(0xFFA2CED9)
internal val Teal90 = Color(0xFFBEEAF6)

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
            colorScheme = darkColorScheme(
                primary = Green80,
                onPrimary = Green20,
                primaryContainer = Green30,
                onPrimaryContainer = Green90,
                secondary = DarkGreen80,
                onSecondary = DarkGreen20,
                secondaryContainer = DarkGreen30,
                onSecondaryContainer = DarkGreen90,
                tertiary = Teal80,
                onTertiary = Teal20,
                tertiaryContainer = Teal30,
                onTertiaryContainer = Teal90,
                error = Red80,
                onError = Red20,
                errorContainer = Red30,
                onErrorContainer = Red90,
                background = DarkGreenGray10,
                onBackground = DarkGreenGray90,
                surface = DarkGreenGray10,
                onSurface = DarkGreenGray90,
                surfaceVariant = GreenGray30,
                onSurfaceVariant = GreenGray80,
                inverseSurface = DarkGreenGray20,
                inverseOnSurface = DarkGreenGray95,
                outline = GreenGray60,
            )
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
            colorScheme = lightColorScheme(
                primary = Green40,
                onPrimary = Color.White,
                primaryContainer = Green90,
                onPrimaryContainer = Green10,
                secondary = DarkGreen40,
                onSecondary = Color.White,
                secondaryContainer = DarkGreen90,
                onSecondaryContainer = DarkGreen10,
                tertiary = Teal40,
                onTertiary = Color.White,
                tertiaryContainer = Teal80,
                onTertiaryContainer = Teal10,
                error = Red40,
                onError = Color.White,
                errorContainer = Red90,
                onErrorContainer = Red10,
                background = DarkGreenGray99,
                onBackground = DarkGreenGray10,
                surface = DarkGreenGray99,
                onSurface = DarkGreenGray10,
                surfaceVariant = GreenGray90,
                onSurfaceVariant = GreenGray30,
                inverseSurface = DarkGreenGray20,
                inverseOnSurface = DarkGreenGray95,
                outline = GreenGray50,
            )
        )
    }

}
