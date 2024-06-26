package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.store.DataState
import shared.design.icon.AppIcons

/**
 * Text field.
 *
 * @param modifier Modifier to be applied to the text field.
 * @param valueState DataState containing the value of the text field.
 * @param placeholder Placeholder text for the text field.
 * @param supportingText Supporting text to be displayed below the text field.
 */
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    valueState: DataState<String>,
    placeholder: String,
    supportingText: String? = null
) {
    OutlinedTextField(
        modifier = modifier,
        onValueChange = valueState::set,
        shape = RoundedCornerShape(8.dp),
        value = valueState.asStateValue().orEmpty(),
        placeholder = { AppText(text = placeholder) },
        suffix = {
            if (!valueState.asStateValue().isNullOrEmpty()) {
                AppActionButton(
                    modifier = Modifier.size(24.dp),
                    icon = AppIcons.cancel,
                    onClick = valueState::clear
                )
            }
        },
        supportingText = supportingText?.let { { Text(it) } }
    )
}