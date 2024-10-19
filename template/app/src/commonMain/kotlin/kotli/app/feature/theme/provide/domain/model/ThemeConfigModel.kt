package kotli.app.feature.theme.provide.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ThemeConfigModel(
    val defaultThemeId: String? = null,
    val lightThemeId: String? = null,
    val darkThemeId: String? = null,
    val autoDark: Boolean? = null,
)