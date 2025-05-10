package shared.presentation.ui.container

import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.presentation.ui.component.DsActionButton
import shared.presentation.ui.component.DsSpacerStatusBar
import shared.presentation.ui.icon.DsIcons
import shared.presentation.ui.theme.DsTheme

@Composable
@NonRestartableComposable
fun DsFixedTopBarLayout(
    modifier: Modifier = Modifier.imePadding(),
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        DsSpacerStatusBar()
        HeaderBlock(title, onBack, actions)
        content()
    }
}

@Composable
@NonRestartableComposable
fun DsFixedTopBarColumn(
    modifier: Modifier = Modifier.imePadding(),
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    footer: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    DsFixedHeaderFooterColumn(
        modifier = modifier.fillMaxSize(),
        appearance = DsFixedHeaderFooterAppearance.default(
            footerBrush = null
        ),
        header = { HeaderBlock(title, onBack, actions) },
        content = content,
        footer = footer
    )
}

@Composable
@NonRestartableComposable
fun DsFixedTopBarLazyColumn(
    modifier: Modifier = Modifier.imePadding(),
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    footer: @Composable (ColumnScope.() -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {
    DsFixedHeaderFooterLazyColumn(
        modifier = modifier,
        appearance = DsFixedHeaderFooterAppearance.default(
            footerBrush = null
        ),
        header = { HeaderBlock(title, onBack, actions) },
        content = content,
        footer = footer
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
            titleContentColor = DsTheme.current.onSurface,
            actionIconContentColor = DsTheme.current.onSurface,
            navigationIconContentColor = DsTheme.current.onSurface,
        ),
        title = {
            if (title != null) {
                Text(text = title)
            }
        },
        actions = actions,
        navigationIcon = {
            if (onBack != null) {
                DsActionButton(
                    onClick = onBack,
                    icon = DsIcons.arrowBack
                )
            }
        }
    )
}