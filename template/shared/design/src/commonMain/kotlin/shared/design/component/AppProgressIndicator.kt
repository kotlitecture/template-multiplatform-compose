package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Circular progress indicator.
 *
 * @param modifier Modifier to be applied to the circular progress indicator.
 */
@Composable
@NonRestartableComposable
fun AppCircularProgressIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    CircularProgressIndicator(
        modifier = modifier
            .size(size),
        strokeWidth = 3.dp
    )
}