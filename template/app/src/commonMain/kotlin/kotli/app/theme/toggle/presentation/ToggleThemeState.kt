package kotli.app.theme.toggle.presentation

import androidx.compose.runtime.Stable
import shared.presentation.ui.icon.AppIconModel

@Stable
interface ToggleThemeState {

    fun isDark(): Boolean?

    fun getIcon(): AppIconModel?

}