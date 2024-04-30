package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.core.state.StoreObject

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    valueStore: StoreObject<String>,
    placeholder: String
) {
    OutlinedTextField(
        modifier = modifier,
        onValueChange = valueStore::set,
        value = valueStore.asStateValue().orEmpty(),
        placeholder = { AppText(text = placeholder) },
        suffix = {
            if (!valueStore.asStateValue().isNullOrEmpty()) {
                AppActionButton(
                    modifier = Modifier.size(24.dp),
                    icon = Icons.Default.Cancel,
                    onClick = valueStore::clear
                )
            }
        }
    )
}