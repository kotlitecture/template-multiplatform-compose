package shared.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier

@Composable
@NonRestartableComposable
fun DsHorizontalDivider(modifier: Modifier = Modifier.fillMaxWidth()) {
    HorizontalDivider(modifier)
}