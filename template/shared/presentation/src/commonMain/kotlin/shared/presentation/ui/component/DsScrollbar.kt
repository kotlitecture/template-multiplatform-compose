package shared.presentation.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import shared.presentation.ui.theme.DsTheme
import shared.presentation.ui.component.scrollbar.ScrollbarStyle
import shared.presentation.ui.component.scrollbar.ThumbStyle
import shared.presentation.ui.component.scrollbar.TrackStyle
import shared.presentation.ui.component.scrollbar.VerticalScrollbar
import shared.presentation.ui.component.scrollbar.rememberScrollbarAdapter

@Composable
@NonRestartableComposable
fun DsVerticalScrollbarProvider(
    modifier: Modifier = Modifier,
    minimumItemCount: Int = 20,
    state: LazyListState = rememberLazyListState(),
    content: @Composable (state: LazyListState) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        content(state)
        DsVerticalScrollbar(
            modifier = Modifier.align(Alignment.TopEnd),
            minimumItemCount = minimumItemCount,
            state = state
        )
    }
}

@Composable
private fun DsVerticalScrollbar(
    modifier: Modifier,
    state: LazyListState,
    minimumItemCount: Int
) {
    if (state.layoutInfo.totalItemsCount < minimumItemCount) return
    var isScrollInProgress by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isDragging by interactionSource.collectIsDraggedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()
    val scrollbarAlpha = remember { Animatable(0f) }

    LaunchedEffect(state) {
        snapshotFlow { state.isScrollInProgress }
            .distinctUntilChanged()
            .collect { isScrollInProgress = it }
    }
    LaunchedEffect(isDragging, isHovered, isScrollInProgress) {
        launch {
            if (isDragging || isHovered || isScrollInProgress) {
                scrollbarAlpha.animateTo(1f)
            } else {
                delay(2000L)
                scrollbarAlpha.animateTo(0f)
            }
        }
    }

    VerticalScrollbar(
        modifier = modifier
            .fillMaxHeight()
            .graphicsLayer {
                alpha = scrollbarAlpha.value
            },
        adapter = rememberScrollbarAdapter(scrollState = state),
        style = defaultMaterialScrollbarStyle(),
        interactionSource = interactionSource,
        enablePressToScroll = false
    )
}

@Composable
private fun defaultMaterialScrollbarStyle(): ScrollbarStyle {
    val colorScheme = DsTheme.current.colorScheme
    return remember(colorScheme) {
        val thumbColor = Color(colorScheme.primary.toArgb())
        val trackColor = Color(colorScheme.surfaceColorAtElevation(8.dp).toArgb())
        ScrollbarStyle(
            minimalHeight = 48.dp,
            thickness = 12.dp,
            hoverDurationMillis = 300,
            thumbStyle = ThumbStyle(
                shape = RoundedCornerShape(8.dp),
                unhoverColor = thumbColor,
                hoverColor = thumbColor,
            ),
            trackStyle = TrackStyle(
                shape = RectangleShape,
                unhoverColor = trackColor,
                hoverColor = trackColor,
            ),
        )
    }
}