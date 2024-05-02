package shared.design.component

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
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