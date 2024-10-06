package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.design.icon.AppIcons

/**
 * Text field.
 *
 * @param modifier Modifier to be applied to the text field.
 * @param valueState MutableState containing the value of the text field.
 * @param placeholder Placeholder text for the text field.
 * @param enabled - controls the enabled state of this text field. When false, this component will not respond to user input, and it will appear visually disabled and disabled to accessibility services.
 * @param readOnly - controls the editable state of the text field. When true, the text field cannot be modified. However, a user can focus it and copy text from it. Read-only text fields are usually used to display pre-filled forms that a user cannot edit.
 * @param singleLine - when true, this text field becomes a single horizontally scrolling text field instead of wrapping onto multiple lines.
 * @param supportingText Supporting text to be displayed below the text field.
 */
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    placeholder: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    supportingText: String? = null
) {
    AppTextField(
        modifier = modifier,
        getValue = valueState::value::get,
        onValueChange = valueState::value::set,
        placeholder = placeholder,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        supportingText = supportingText
    )
}

/**
 * Text field.
 *
 * @param modifier Modifier to be applied to the text field.
 * @param getValue Returns the value to display in the text field.
 * @param onValueChange The callback that is triggered when the input service updates the text. An updated text comes as a parameter of the callback.
 * @param placeholder Placeholder text for the text field.
 * @param enabled - controls the enabled state of this text field. When false, this component will not respond to user input, and it will appear visually disabled and disabled to accessibility services.
 * @param readOnly - controls the editable state of the text field. When true, the text field cannot be modified. However, a user can focus it and copy text from it. Read-only text fields are usually used to display pre-filled forms that a user cannot edit.
 * @param singleLine - when true, this text field becomes a single horizontally scrolling text field instead of wrapping onto multiple lines.
 * @param supportingText Supporting text to be displayed below the text field.
 */
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    getValue: () -> String,
    onValueChange: (value: String) -> Unit,
    placeholder: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    supportingText: String? = null
) {
    val value = getValue()
    OutlinedTextField(
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(8.dp),
        value = value,
        placeholder = { AppText(text = placeholder) },
        suffix = (enabled && !readOnly).takeIf { value.isNotEmpty() }
            ?.let {
                {
                    AppActionButton(
                        modifier = Modifier.size(24.dp),
                        icon = AppIcons.cancel,
                        onClick = { onValueChange("") }
                    )
                }
            },
        supportingText = supportingText
            ?.let {
                {
                    Text((supportingText))
                }
            }
    )
}