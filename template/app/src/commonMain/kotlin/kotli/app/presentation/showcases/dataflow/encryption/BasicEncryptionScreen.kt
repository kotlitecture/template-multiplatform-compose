package kotli.app.presentation.showcases.dataflow.encryption

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.design.component.AppText
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.store.DataState
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BasicEncryptionScreen() {
    val viewModel: BasicEncryptionViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = BasicEncryptionShowcase.label,
        onBack = viewModel::onBack,
        content = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "Enter password",
                    supportingText = "Password",
                    valueState = viewModel.pwdState
                )

                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "Enter text",
                    supportingText = "Text",
                    valueState = viewModel.textState
                )
            }
            AppTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                placeholder = "",
                supportingText = "This text is encrypted based on the entered password and text",
                valueState = viewModel.encryptedTextState,
                readOnly = true
            )
            AppTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                placeholder = "",
                supportingText = "This text is decrypted based on the entered password and encrypted text",
                valueState = viewModel.decryptedTextState,
                readOnly = true
            )
        }
    )
}

@Composable
private fun FieldBlock(
    modifier: Modifier,
    label: String,
    state: DataState<String>
) {
    AppTextField(
        modifier = modifier,
        placeholder = label,
        supportingText = label,
        valueState = state
    )
}