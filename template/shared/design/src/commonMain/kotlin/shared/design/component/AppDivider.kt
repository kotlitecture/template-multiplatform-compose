package shared.design.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Horizontal divider.
 *
 * @param modifier Modifier to be applied to the divider.
 */
@Composable
fun AppHorizontalDivider(modifier: Modifier = Modifier.fillMaxWidth()) {
    HorizontalDivider(modifier)
}