package shared.presentation.ui.component

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier

@Composable
@NonRestartableComposable
fun AppRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: (() -> Unit)?
) {
    RadioButton(
        modifier = modifier,
        selected = selected,
        onClick = onClick
    )
}