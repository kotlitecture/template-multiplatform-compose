package shared.presentation.ui.component.scrollbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import kotlin.math.roundToInt

/**
 * The actual implementation of the scrollbar.
 */
@Composable
internal fun Scrollbar(
    adapter: ScrollbarAdapter,
    reverseLayout: Boolean,
    style: ScrollbarStyle,
    interactionSource: MutableInteractionSource,
    isVertical: Boolean,
    enablePressToScroll: Boolean,
    indicator: @Composable (position: Float, isVisible: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val dragInteraction = remember { mutableStateOf<DragInteraction.Start?>(null) }
    DisposableEffect(interactionSource) {
        onDispose {
            dragInteraction.value?.let { interaction ->
                interactionSource.tryEmit(DragInteraction.Cancel(interaction))
                dragInteraction.value = null
            }
        }
    }

    var containerSize by remember { mutableStateOf(0) }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val isHighlighted by remember {
        derivedStateOf {
            isHovered || dragInteraction.value is DragInteraction.Start
        }
    }

    val minimalHeight = with(LocalDensity.current) { style.minimalHeight.toPx() }

    val coroutineScope = rememberCoroutineScope()
    val sliderAdapter = remember(
        adapter, containerSize, minimalHeight, reverseLayout, isVertical, coroutineScope
    ) {
        SliderAdapter(
            adapter,
            containerSize,
            minimalHeight,
            reverseLayout,
            isVertical,
            coroutineScope
        )
    }

    val scrollThickness = with(LocalDensity.current) { style.thickness.toPx() }
    val measurePolicy = if (isVertical) {
        remember(sliderAdapter, scrollThickness) {
            verticalMeasurePolicy(
                sliderAdapter,
                { containerSize = it },
                scrollThickness.roundToInt()
            )
        }
    } else {
        remember(sliderAdapter, scrollThickness) {
            horizontalMeasurePolicy(
                sliderAdapter,
                { containerSize = it },
                scrollThickness.roundToInt()
            )
        }
    }

    val thumbColor by animateColorAsState(
        if (isHighlighted) style.thumbStyle.hoverColor else style.thumbStyle.unhoverColor,
        animationSpec = TweenSpec(durationMillis = style.hoverDurationMillis)
    )

    val trackColor by animateColorAsState(
        if (isHighlighted) style.trackStyle.hoverColor else style.trackStyle.unhoverColor,
        animationSpec = TweenSpec(durationMillis = style.hoverDurationMillis)
    )

    val isVisible = sliderAdapter.thumbSize < containerSize

    indicator(sliderAdapter.position.toFloat(), isVisible)

    Box(
        modifier = modifier
            .width(style.thickness)
            .graphicsLayer {
                clip = true
                shape = style.trackStyle.shape
            }
            .drawBehind { drawRect(if (isVisible) trackColor else Color.Transparent) },
    )

    Layout(
        content = {
            Box(
                modifier = Modifier
                    .scrollbarDrag(
                        interactionSource = interactionSource,
                        draggedInteraction = dragInteraction,
                        sliderAdapter = sliderAdapter,
                        enableDragAnywhere = false,
                    )
                    .graphicsLayer {
                        clip = true
                        shape = style.thumbStyle.shape
                    }
                    .drawBehind { drawRect(if (isVisible) thumbColor else Color.Transparent) },
            )
        },
        modifier = modifier
            .hoverable(interactionSource = interactionSource)
            .then(
                if (enablePressToScroll) {
                    Modifier.scrollOnPressTrack(isVertical, reverseLayout, sliderAdapter)
                } else {
                    Modifier.scrollbarDrag(
                        interactionSource = interactionSource,
                        draggedInteraction = dragInteraction,
                        sliderAdapter = sliderAdapter,
                        enableDragAnywhere = true,
                    )
                }
            ),
        measurePolicy = measurePolicy,
    )
}

private fun verticalMeasurePolicy(
    sliderAdapter: SliderAdapter,
    setContainerSize: (Int) -> Unit,
    scrollThickness: Int,
): MeasurePolicy {
    return MeasurePolicy { measurables, constraints ->
        setContainerSize(constraints.maxHeight)
        val pixelRange = sliderAdapter.thumbPixelRange
        val placeable = measurables.first().measure(
            Constraints.fixed(
                width = constraints.constrainWidth(scrollThickness),
                height = pixelRange.size,
            )
        )

        layout(
            width = placeable.width,
            height = constraints.maxHeight,
        ) {
            placeable.place(0, pixelRange.first)
        }
    }
}

private fun horizontalMeasurePolicy(
    sliderAdapter: SliderAdapter,
    setContainerSize: (Int) -> Unit,
    scrollThickness: Int,
): MeasurePolicy {
    return MeasurePolicy { measurables, constraints ->
        setContainerSize(constraints.maxWidth)
        val pixelRange = sliderAdapter.thumbPixelRange
        val placeable = measurables.first().measure(
            Constraints.fixed(
                width = pixelRange.size,
                height = constraints.constrainHeight(scrollThickness),
            )
        )

        layout(
            width = constraints.maxWidth,
            height = placeable.height,
        ) {
            placeable.place(pixelRange.first, 0)
        }
    }
}

private val IntRange.size: Int
    get() = last + 1 - first
