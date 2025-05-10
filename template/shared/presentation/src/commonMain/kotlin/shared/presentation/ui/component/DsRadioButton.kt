package shared.presentation.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
fun DsRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: (() -> Unit)?
) {
    RadioButton(
        modifier = modifier.size(24.dp),
        selected = selected,
        onClick = onClick
    )
}