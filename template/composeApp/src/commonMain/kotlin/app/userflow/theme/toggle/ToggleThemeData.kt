package app.userflow.theme.toggle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import shared.core.theme.ThemeContext

/**
 * Data class representing theme toggle data.
 *
 * @param context The theme data provider.
 */
@Immutable
data class ToggleThemeData(
    private val context: ThemeContext
) {

    @Stable
    fun isDark(): Boolean {
        return context.dark
    }

    @Stable
    fun getIcon(): ImageVector {
        return when {
            context.dark -> Icons.Outlined.LightMode
            else -> Icons.Outlined.DarkMode
        }
    }
}