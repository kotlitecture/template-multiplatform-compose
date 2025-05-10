package shared.presentation.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import shared.presentation.ui.icon.DsIcons

@Composable
fun DsTextField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    placeholder: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    supportingText: String? = null,
    autoFocus: Boolean = false
) {
    DsTextField(
        modifier = modifier,
        getValue = valueState::value::get,
        onValueChange = valueState::value::set,
        placeholder = placeholder,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        supportingText = supportingText,
        autoFocus = autoFocus
    )
}

@Composable
fun DsTextField(
    modifier: Modifier = Modifier,
    getValue: () -> String,
    onValueChange: (value: String) -> Unit,
    placeholder: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    supportingText: String? = null,
    autoFocus: Boolean = false
) {
    val value = getValue()
    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        modifier = modifier.then(
            if (autoFocus) Modifier.focusRequester(focusRequester) else Modifier
        ),
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(8.dp),
        value = value,
        placeholder = { DsText(text = placeholder) },
        suffix = (enabled && !readOnly).takeIf { value.isNotEmpty() }
            ?.let {
                {
                    DsActionButton(
                        modifier = Modifier.size(24.dp),
                        icon = DsIcons.cancel,
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

    if (autoFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}
