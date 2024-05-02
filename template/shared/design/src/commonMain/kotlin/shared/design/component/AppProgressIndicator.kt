package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Circular progress indicator.
 *
 * @param modifier Modifier to be applied to the circular progress indicator.
 */
@Composable
fun AppCircularProgressIndicator(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
            .size(40.dp),
        strokeWidth = 3.dp
    )
}