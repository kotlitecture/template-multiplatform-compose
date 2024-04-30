package shared.design.container

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.core.theme.ThemeContext
import shared.design.component.AppActionButton

/**
 * Composable function for rendering a layout with a fixed top bar.
 *
 * @param title The title text to display in the top app bar.
 * @param onBack The callback to be invoked when the back navigation icon is clicked.
 * @param content The content to be displayed below the top bar.
 */
@Composable
fun AppFixedTopBarColumn(
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    AppFixedHeaderFooterColumn(
        modifier = Modifier.fillMaxSize(),
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

@OptIn(ExperimentalMaterial3Api::class)
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
            titleContentColor = ThemeContext.current.onPrimary,
            actionIconContentColor = ThemeContext.current.onPrimary,
            navigationIconContentColor = ThemeContext.current.onPrimary,
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
                    icon = Icons.Default.ArrowBackIosNew
                )
            }
        }
    )
}