package kotli.app.feature.theme.provide.domain

import kotlinx.serialization.Serializable

@Serializable
data class ThemeConfigModel(
    val defaultThemeId: String? = null,
    val lightThemeId: String? = null,
    val darkThemeId: String? = null,
    val autoDark: Boolean? = null,
)