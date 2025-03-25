package shared.presentation.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.ui.icon.AppIcons

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