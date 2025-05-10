package shared.presentation.ui.theme

import shared.presentation.ui.theme.m3.highContrastDarkColorScheme
import shared.presentation.ui.theme.m3.highContrastLightColorScheme

object DsThemes {

    val Light = DsTheme(
        id = "light",
        dark = false,
        colorScheme = highContrastLightColorScheme
    )

    val Dark = DsTheme(
        id = "dark",
        dark = true,
        colorScheme = highContrastDarkColorScheme
    )
}