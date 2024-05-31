package kotli.app.feature.theme.toggle

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import org.jetbrains.compose.resources.DrawableResource
import shared.core.theme.ThemeData
import shared.design.AppIcons

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
    fun getIcon(): DrawableResource {
        return when {
            data.context.dark -> AppIcons.LightMode
            else -> AppIcons.DarkMode
        }
    }
}