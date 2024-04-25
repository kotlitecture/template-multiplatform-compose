package app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

/**
 * Represents a navigation bar page item.
 *
 * @param id The unique id associated with the page item.
 * @param enabled Indicates whether the page item is enabled or disabled. Default is true.
 * @param alwaysShowLabel Indicates whether to always show the label, regardless of its presence. Default is true if label is not null.
 * @param getLabel The label of the page item.
 * @param getActiveIcon The icon of the page item.
 * @param getInactiveIcon The icon of the page item in inactive state.
 * @param onClick The callback to be invoked when the page item is clicked.
 */
data class NavigationBarPage(
    val id: String,
    val enabled: Boolean = true,
    val alwaysShowLabel: Boolean = true,
    val getLabel: @Composable () -> String?,
    val getActiveIcon: () -> Any,
    val getInactiveIcon: () -> Any,
    val onClick: () -> Unit
) {
    @Stable
    fun getIcon(selected: Boolean): Any {
        return if (selected) {
            getActiveIcon()
        } else {
            getInactiveIcon()
        }
    }
}