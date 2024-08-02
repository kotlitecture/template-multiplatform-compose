package shared.design.component.scrollbar

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Defines visual style of scrollbars (thickness, shapes, colors, etc).
 * Can be passed as a parameter of scrollbar.
 */
@Immutable
internal data class ScrollbarStyle(
    val minimalHeight: Dp,
    val thickness: Dp,
    val hoverDurationMillis: Int,
    val thumbStyle: ThumbStyle,
    val trackStyle: TrackStyle,
)

/**
 * Defines visual style of scrollbar thumb.
 * Can be passed as a parameter of scrollbar.
 */
@Immutable
internal data class ThumbStyle(
    val shape: Shape,
    val unhoverColor: Color,
    val hoverColor: Color,
)

/**
 * Defines visual style of scrollbar track.
 * Can be passed as a parameter of scrollbar.
 */
@Immutable
internal data class TrackStyle(
    val shape: Shape,
    val unhoverColor: Color,
    val hoverColor: Color,
)