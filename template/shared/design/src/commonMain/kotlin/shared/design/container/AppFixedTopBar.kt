package shared.design.container

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.design.icon.AppIcons
import shared.design.component.AppActionButton
import shared.design.theme.AppTheme

/**
 * Composable function for rendering a layout with a fixed top bar.
 *
 * @param title The title text to display in the top app bar.
 * @param onBack The callback to be invoked when the back navigation icon is clicked.
 * @param content The content to be displayed below the top bar.
 */
@Composable
fun AppFixedTopBarColumn(
    modifier: Modifier = Modifier.imePadding(),
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    AppFixedHeaderFooterColumn(
        modifier = modifier.fillMaxSize(),
        appearance = AppFixedHeaderFooterAppearance.default(
            footerBrush = null
        ),
        header = { HeaderBlock(title, onBack, actions) },
        content = content,
        footer = {}
    )
}

/**
 * Composable function for rendering a layout with a fixed top bar.
 *
 * @param title The title text to display in the top app bar.
 * @param onBack The callback to be invoked when the back navigation icon is clicked.
 * @param content The content to be displayed below the top bar.
 */
@Composable
fun AppFixedTopBarLazyColumn(
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: LazyListScope.() -> Unit
) {
    AppFixedHeaderFooterLazyColumn(
        modifier = Modifier.fillMaxSize(),
        appearance = AppFixedHeaderFooterAppearance.default(
            footerBrush = null
        ),
        header = { HeaderBlock(title, onBack, actions) },
        content = content,
        footer = {}
    )
}

@Composable
private fun HeaderBlock(
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        windowInsets = WindowInsets.systemBars.exclude(WindowInsets.systemBars),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = AppTheme.current.onSurface,
            actionIconContentColor = AppTheme.current.onSurface,
            navigationIconContentColor = AppTheme.current.onSurface,
        ),
        title = {
            if (title != null) {
                Text(text = title)
            }
        },
        actions = actions,
        navigationIcon = {
            if (onBack != null) {
                AppActionButton(
                    onClick = onBack,
                    icon = AppIcons.arrowBack
                )
            }
        }
    )
}