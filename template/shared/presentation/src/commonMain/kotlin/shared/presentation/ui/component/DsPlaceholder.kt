package shared.presentation.ui.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import shared.presentation.ui.theme.DsTheme

fun Modifier.withPlaceholder(
    visible: Boolean,
    cornerRadius: Dp = 4.dp
) = if (!visible) {
    this
} else {
    composed {
        val colors = DsTheme.current.shimmerColors
        val transition = rememberInfiniteTransition()
        val translateAnim by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1200,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )

        drawWithContent {
            val brush = Brush.linearGradient(
                colors = colors,
                start = Offset(x = translateAnim - 1000f, y = 0f),
                end = Offset(x = translateAnim, y = 1000f)
            )
            drawRoundRect(
                brush = brush,
                cornerRadius = CornerRadius(cornerRadius.toPx()),
            )
        }
    }
}

