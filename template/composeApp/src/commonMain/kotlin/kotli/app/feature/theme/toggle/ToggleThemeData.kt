package kotli.app.feature.theme.toggle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import shared.core.theme.ThemeData

/**
 * Data class representing theme toggle data.
 *
 * @param context The theme data provider.
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
    fun getIcon(): ImageVector {
        return when {
            data.context.dark -> Icons.Outlined.LightMode
            else -> Icons.Outlined.DarkMode
        }
    }
}