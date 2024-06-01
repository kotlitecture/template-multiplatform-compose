package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.core.state.StoreObject
import shared.design.icon.AppIcons

/**
 * Text field.
 *
 * @param modifier Modifier to be applied to the text field.
 * @param valueStore StoreObject containing the value of the text field.
 * @param placeholder Placeholder text for the text field.
 * @param supportingText Supporting text to be displayed below the text field.
 */
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    valueStore: StoreObject<String>,
    placeholder: String,
    supportingText: String? = null
) {
    OutlinedTextField(
        modifier = modifier,
        onValueChange = valueStore::set,
        shape = RoundedCornerShape(8.dp),
        value = valueStore.asStateValue().orEmpty(),
        placeholder = { AppText(text = placeholder) },
        suffix = {
            if (!valueStore.asStateValue().isNullOrEmpty()) {
                AppActionButton(
                    modifier = Modifier.size(24.dp),
                    icon = AppIcons.cancel,
                    onClick = valueStore::clear
                )
            }
        },
        supportingText = supportingText?.let { { Text(it) } }
    )
}