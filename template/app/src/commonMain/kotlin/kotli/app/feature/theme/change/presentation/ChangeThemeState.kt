package kotli.app.feature.theme.change.presentation

import androidx.compose.runtime.Stable
import shared.presentation.theme.ThemeConfig

@Stable
interface ChangeThemeState {

    val currentConfig: ThemeConfig?
    val dynamic: Boolean?

}