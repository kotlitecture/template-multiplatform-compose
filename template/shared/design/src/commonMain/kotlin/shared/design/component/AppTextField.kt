package shared.design.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        placeholder = { AppText(text = placeholder) }
    )
}