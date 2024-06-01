package kotli.app.feature.theme.toggle

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import shared.core.theme.ThemeData
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons

/**
 * Data class representing theme toggle data.
 */
@Immutable
data class ToggleThemeData(
    private val data: ThemeData
) {

    @Stable
    fun isDark(): Boolean {
        return data.context.dark
    }

    @Stable
    fun getIcon(): AppIconModel {
        return when {
            data.context.dark -> AppIcons.lightMode
            else -> AppIcons.darkMode
        }
    }
}