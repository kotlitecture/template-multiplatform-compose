package shared.design.component

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Radio button.
 *
 * @param modifier Modifier to be applied to the radio button.
 * @param selected Whether the radio button is selected.
 * @param onClick Callback to be invoked when the radio button is clicked.
 */
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