package app.userflow.theme.toggle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import core.ui.theme.ThemeDataProvider

/**
 * Data class representing theme toggle data.
 *
 * @param provider The theme data provider.
 */
@Immutable
data class ToggleThemeData(
    private val provider: ThemeDataProvider<*>
) {

    @Stable
    fun isDark(): Boolean {
        return provider.dark
    }

    @Stable
    fun getIcon(): ImageVector {
        return when {
            provider.dark -> Icons.Outlined.LightMode
            else -> Icons.Outlined.DarkMode
        }
    }
}