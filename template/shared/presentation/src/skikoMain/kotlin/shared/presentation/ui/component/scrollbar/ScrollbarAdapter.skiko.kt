package shared.presentation.ui.component.scrollbar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.text.TextFieldScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual typealias ScrollbarAdapter = androidx.compose.foundation.v2.ScrollbarAdapter

/**
 * Create and [remember] [ScrollbarAdapter] for
 * scrollable container with the given instance [ScrollState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: ScrollState
): ScrollbarAdapter = androidx.compose.foundation.rememberScrollbarAdapter(scrollState)

/**
 * Create and [remember] [ScrollbarAdapter] for
 * lazy scrollable container with the given instance [LazyListState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: LazyListState,
): ScrollbarAdapter = androidx.compose.foundation.rememberScrollbarAdapter(scrollState)

/**
 * Create and [remember] [ScrollbarAdapter] for lazy grid with
 * the given instance of [LazyGridState].
 */
@Composable
actual fun rememberScrollbarAdapter(
    scrollState: LazyGridState,
): ScrollbarAdapter = androidx.compose.foundation.rememberScrollbarAdapter(scrollState)

/**
 * Create and [remember] [ScrollbarAdapter] for text field with
 * the given instance of [TextFieldScrollState].
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberScrollbarAdapter(
    scrollState: TextFieldScrollState,
): ScrollbarAdapter = androidx.compose.foundation.rememberScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for Modifier.verticalScroll and Modifier.horizontalScroll
 *
 * [scrollState] is instance of [ScrollState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: ScrollState
): ScrollbarAdapter = androidx.compose.foundation.ScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for lazy lists.
 *
 * [scrollState] is instance of [LazyListState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: LazyListState
): ScrollbarAdapter = androidx.compose.foundation.ScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for lazy grids.
 *
 * [scrollState] is instance of [LazyGridState] which is used by scrollable component
 */
actual fun ScrollbarAdapter(
    scrollState: LazyGridState
): ScrollbarAdapter = androidx.compose.foundation.ScrollbarAdapter(scrollState)

/**
 * ScrollbarAdapter for text fields.
 *
 * [scrollState] is instance of [TextFieldScrollState] which is used by scrollable component
 */
@OptIn(ExperimentalFoundationApi::class)
fun ScrollbarAdapter(
    scrollState: TextFieldScrollState
): androidx.compose.foundation.v2.ScrollbarAdapter =
    androidx.compose.foundation.ScrollbarAdapter(scrollState)
