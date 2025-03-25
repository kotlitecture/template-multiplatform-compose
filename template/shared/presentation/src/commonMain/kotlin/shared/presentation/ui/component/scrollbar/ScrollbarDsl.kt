package shared.presentation.ui.component.scrollbar

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

/**
 * Vertical scrollbar that can be attached to some scrollable
 * component (ScrollableColumn, LazyColumn) and share common state with it.
 *
 * Can be placed independently.
 *
 * Example:
 *     val state = rememberScrollState(0)
 *
 *     Box(Modifier.fillMaxSize()) {
 *         Box(modifier = Modifier.verticalScroll(state)) {
 *             ...
 *         }
 *
 *         VerticalScrollbar(
 *             adapter = rememberScrollbarAdapter(state)
 *             modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
 *         )
 *     }
 *
 * @param adapter [ScrollbarAdapter] that will be used to
 * communicate with scrollable component
 * @param modifier the modifier to apply to this layout
 * @param reverseLayout reverse the direction of scrolling and layout, when `true`
 * and LazyListState.firstVisibleItemIndex == 0 then scrollbar
 * will be at the bottom of the container.
 * It is usually used in pair with `LazyColumn(reverseLayout = true)`
 * @param style [ScrollbarStyle] to define visual style of scrollbar
 * @param interactionSource [MutableInteractionSource] that will be used to dispatch
 * [DragInteraction.Start] when this Scrollbar is being dragged.
 * @param enablePressToScroll enable press to scroll on scrollbar track
 * @param indicator compose indicator to this layout
 *
 */
@Composable
internal fun VerticalScrollbar(
    adapter: shared.presentation.ui.component.scrollbar.ScrollbarAdapter,
    style: ScrollbarStyle,
    modifier: Modifier = Modifier,
    reverseLayout: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enablePressToScroll: Boolean = true,
    indicator: @Composable (position: Float, isVisible: Boolean) -> Unit = { _, _ -> },
) {
    Scrollbar(
        adapter = adapter,
        modifier = modifier,
        reverseLayout = reverseLayout,
        style = style,
        interactionSource = interactionSource,
        isVertical = true,
        enablePressToScroll = enablePressToScroll,
        indicator = indicator,
    )
}

/**
 * Horizontal scrollbar that can be attached to some scrollable
 * component (Modifier.verticalScroll(), LazyRow) and share common state with it.
 *
 * Can be placed independently.
 *
 * Example:
 *     val state = rememberScrollState(0)
 *
 *     Box(Modifier.fillMaxSize()) {
 *         Box(modifier = Modifier.verticalScroll(state)) {
 *             ...
 *         }
 *
 *         HorizontalScrollbar(
 *             adapter = rememberScrollbarAdapter(state)
 *             modifier = Modifier.align(Alignment.CenterEnd).fillMaxWidth(),
 *         )
 *     }
 *
 * @param adapter [ScrollbarAdapter] that will be used to
 * communicate with scrollable component
 * @param modifier the modifier to apply to this layout
 * @param reverseLayout reverse the direction of scrolling and layout, when `true`
 * and LazyListState.firstVisibleItemIndex == 0 then scrollbar
 * will be at the end of the container.
 * It is usually used in pair with `LazyRow(reverseLayout = true)`
 * @param style [ScrollbarStyle] to define visual style of scrollbar
 * @param interactionSource [MutableInteractionSource] that will be used to dispatch
 * [DragInteraction.Start] when this Scrollbar is being dragged.
 * @param enablePressToScroll enable press to scroll on scrollbar track
 * @param indicator compose indicator to this layout
 */
@Composable
internal fun HorizontalScrollbar(
    adapter: shared.presentation.ui.component.scrollbar.ScrollbarAdapter,
    style: ScrollbarStyle,
    modifier: Modifier = Modifier,
    reverseLayout: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enablePressToScroll: Boolean = true,
    indicator: @Composable (position: Float, isVisible: Boolean) -> Unit = { _, _ -> },
) {
    Scrollbar(
        adapter = adapter,
        modifier = modifier,
        reverseLayout = if (LocalLayoutDirection.current == LayoutDirection.Rtl) !reverseLayout else reverseLayout,
        style = style,
        interactionSource = interactionSource,
        isVertical = false,
        enablePressToScroll = enablePressToScroll,
        indicator = indicator,
    )
}
