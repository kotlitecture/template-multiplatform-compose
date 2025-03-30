package shared.presentation.ui.component.scrollbar

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual typealias ScrollbarAdapter = ScrollbarAdapterAndroid

/**
 * Create and [remember] [ScrollbarAdapter] for
 * scrollable container with the given instance [ScrollState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: ScrollState
): ScrollbarAdapter = remember(scrollState) {
    ScrollbarAdapter(scrollState)
}

/**
 * Create and [remember] [ScrollbarAdapter] for
 * lazy scrollable container with the given instance [LazyListState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: LazyListState,
): ScrollbarAdapter = remember(scrollState) {
    ScrollbarAdapter(scrollState)
}

/**
 * Create and [remember] [ScrollbarAdapter] for lazy grid with
 * the given instance of [LazyGridState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: LazyGridState,
): ScrollbarAdapter = remember(scrollState) {
    ScrollbarAdapter(scrollState)
}

/**
 * ScrollbarAdapter for Modifier.verticalScroll and Modifier.horizontalScroll
 *
 * [scrollState] is instance of [ScrollState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: ScrollState
): ScrollbarAdapter = ScrollableScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for lazy lists.
 *
 * [scrollState] is instance of [LazyListState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: LazyListState
): ScrollbarAdapter = LazyListScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for lazy grids.
 *
 * [scrollState] is instance of [LazyGridState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: LazyGridState
): ScrollbarAdapter = LazyGridScrollbarAdapter(scrollState)
