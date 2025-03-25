package shared.presentation.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eygraber.compose.placeholder.PlaceholderHighlight
import com.eygraber.compose.placeholder.placeholder
import com.eygraber.compose.placeholder.shimmer
import shared.presentation.theme.Theme

fun Modifier.withPlaceholder(
    visible: Boolean,
    cornerRadius: Dp = 4.dp
) = if (visible) {
    composed {
        val theme = Theme.current
        val colorPrimary = theme.highlightPrimary
        val colorSecondary = theme.highlightSecondary
        placeholder(
            visible = true,
            color = colorPrimary,
            shape = remember { RoundedCornerShape(cornerRadius) },
            highlight = remember {
                PlaceholderHighlight.shimmer(
                    highlightColor = colorSecondary
                )
            }
        )
    }
} else {
    this
}