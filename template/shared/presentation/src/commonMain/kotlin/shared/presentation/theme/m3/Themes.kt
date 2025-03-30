package shared.presentation.theme.m3

import shared.presentation.theme.Theme

object Themes {

    val Light = Theme(
        dark = false,
        id = "material_3_light",
        colorScheme = lightScheme
    )

    val Dark = Theme(
        dark = true,
        id = "material_3_dark",
        colorScheme = darkScheme
    )
}