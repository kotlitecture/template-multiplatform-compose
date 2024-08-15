package shared.design.container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onSizeChanged
import shared.design.component.AppSpacerDynamic
import shared.design.component.AppSpacerNavigationBar
import shared.design.component.AppSpacerStatusBar
import shared.design.component.AppVerticalScrollbarProvider
import shared.design.theme.AppTheme

/**
 * Represents the appearance configuration for a layout.
 *
 * @property backgroundColor The background color of the fixed header layout.
 * @property headerBrush The brush used to paint the header section of the fixed header layout.
 * @property footerBrush The brush used to paint the footer section of the fixed header layout.
 * @property statusSpacer Whether to include a spacer for the system status bar.
 * @property navigationSpacer Whether to include a spacer for the system navigation bar.
 */
data class AppFixedHeaderFooterAppearance(
    val backgroundColor: Color,
    val headerBrush: Brush,
    val footerBrush: Brush,
    val statusSpacer: Boolean,
    val navigationSpacer: Boolean
) {
    companion object {
        @Stable
        @Composable
        @ReadOnlyComposable
        fun default(
            backgroundColor: Color = AppTheme.current.surface,
            headerBrush: Brush? = AppTheme.current.topBlur,
            footerBrush: Brush? = AppTheme.current.bottomBlur,
            statusSpacer: Boolean = true,
            navigationSpacer: Boolean = true
        ): AppFixedHeaderFooterAppearance {
            return AppFixedHeaderFooterAppearance(
                backgroundColor = backgroundColor,
                headerBrush = headerBrush ?: SolidColor(Color.Unspecified),
                footerBrush = footerBrush ?: SolidColor(Color.Unspecified),
                statusSpacer = statusSpacer,
                navigationSpacer = navigationSpacer
            )
        }
    }
}

/**
 * Composable function representing a Column layout with fixed header and footer.
 *
 * @param modifier The modifier to apply to the layout.
 * @param appearance The appearance configuration for the fixed header layout.
 * @param header The composable content for the header section.
 * @param footer The composable content for the footer section.
 * @param content The main content of the fixed header layout.
 */
@Composable
fun AppFixedHeaderFooterColumn(
    modifier: Modifier = Modifier.imePadding(),
    appearance: AppFixedHeaderFooterAppearance = AppFixedHeaderFooterAppearance.default(),
    header: @Composable (ColumnScope.() -> Unit)? = null,
    footer: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val headerHeight = remember { mutableStateOf(getDefaultHeight(header)) }
    val footerHeight = remember { mutableStateOf(getDefaultHeight(footer)) }
    Box(modifier = modifier.fillMaxSize()) {
        ContentBlock(appearance, headerHeight, footerHeight, content)
        HeaderBlock(appearance, headerHeight, header)
        FooterBlock(appearance, footerHeight, footer)
    }
}

/**
 * Composable function representing a LazyColumn layout with fixed header and footer.
 *
 * @param modifier The modifier to apply to the layout.
 * @param appearance The appearance configuration for the fixed header layout.
 * @param header The composable content for the header section.
 * @param footer The composable content for the footer section.
 * @param content The main content of the fixed header layout.
 */
@Composable
fun AppFixedHeaderFooterLazyColumn(
    modifier: Modifier = Modifier,
    appearance: AppFixedHeaderFooterAppearance = AppFixedHeaderFooterAppearance.default(),
    header: @Composable (ColumnScope.() -> Unit)? = null,
    footer: @Composable (ColumnScope.() -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {
    val headerHeight = remember { mutableStateOf(getDefaultHeight(header)) }
    val footerHeight = remember { mutableStateOf(getDefaultHeight(footer)) }
    Box(modifier = modifier.fillMaxSize()) {
        ContentBlock(appearance, headerHeight, footerHeight, content)
        HeaderBlock(appearance, headerHeight, header)
        FooterBlock(appearance, footerHeight, footer)
    }
}

@Composable
private fun BoxScope.HeaderBlock(
    appearance: AppFixedHeaderFooterAppearance,
    state: MutableState<Int>,
    content: @Composable (ColumnScope.() -> Unit)?
) {
    if (content == null) return
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)
            .background(appearance.headerBrush)
            .onSizeChanged { state.value = it.height }
    ) {
        if (appearance.statusSpacer) {
            AppSpacerStatusBar()
        }
        content.invoke(this)
    }
}

@Composable
private fun BoxScope.FooterBlock(
    appearance: AppFixedHeaderFooterAppearance,
    state: MutableState<Int>,
    content: @Composable (ColumnScope.() -> Unit)?
) {
    if (content == null) return
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(appearance.footerBrush)
            .onSizeChanged { state.value = it.height }
    ) {
        content.invoke(this)
        if (appearance.navigationSpacer) {
            AppSpacerNavigationBar()
        }
    }
}

@Composable
private fun ContentBlock(
    appearance: AppFixedHeaderFooterAppearance,
    headerState: State<Int>,
    footerState: State<Int>,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appearance.backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        if (headerState.value >= 0 && footerState.value >= 0) {
            AppSpacerDynamic(heightState = headerState)
            content.invoke(this)
            AppSpacerDynamic(heightState = footerState)
        }
    }
}

@Composable
private fun ContentBlock(
    appearance: AppFixedHeaderFooterAppearance,
    headerState: State<Int>,
    footerState: State<Int>,
    content: LazyListScope.() -> Unit
) {
    AppVerticalScrollbarProvider { state ->
        LazyColumn(
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .background(appearance.backgroundColor)
        ) {
            if (headerState.value >= 0 && footerState.value >= 0) {
                item { AppSpacerDynamic(heightState = headerState) }
                content.invoke(this)
                item { AppSpacerDynamic(heightState = footerState) }
            }
        }
    }
}

private fun getDefaultHeight(content: @Composable (ColumnScope.() -> Unit)?): Int {
    if (content == null) return 0
    return -1
}