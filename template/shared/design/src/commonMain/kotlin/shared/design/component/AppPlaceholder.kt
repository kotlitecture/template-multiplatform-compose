package shared.design.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eygraber.compose.placeholder.PlaceholderHighlight
import com.eygraber.compose.placeholder.fade
import com.eygraber.compose.placeholder.placeholder
import com.eygraber.compose.placeholder.shimmer
import shared.design.theme.AppTheme

/**
 * Draws some skeleton UI which is typically used whilst content is 'loading'.
 */
fun Modifier.withPlaceholder(
    visible: Boolean,
    cornerRadius: Dp = 4.dp
) = composed {
    val theme = AppTheme.current
    val colorPrimary = theme.highlightPrimary
    val colorSecondary = theme.highlightSecondary
    placeholder(
        visible = visible,
        color = colorPrimary,
        shape = RoundedCornerShape(cornerRadius),
        highlight = PlaceholderHighlight.shimmer(
            highlightColor = colorSecondary
        )
    )
}