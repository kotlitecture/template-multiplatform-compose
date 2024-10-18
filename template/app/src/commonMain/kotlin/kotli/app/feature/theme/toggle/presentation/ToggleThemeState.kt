package kotli.app.feature.theme.toggle.presentation

import androidx.compose.runtime.Stable
import shared.design.icon.AppIconModel

@Stable
interface ToggleThemeState {

    fun isDark(): Boolean?

    fun getIcon(): AppIconModel?

}