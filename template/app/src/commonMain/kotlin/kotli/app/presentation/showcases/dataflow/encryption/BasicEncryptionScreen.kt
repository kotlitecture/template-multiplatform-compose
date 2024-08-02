package kotli.app.presentation.showcases.dataflow.encryption

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn
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
                    supportingText = "Password to encrypt the text",
                    valueState = viewModel.encryptionPasswordState
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

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "Enter password",
                    supportingText = "Password to decrypt the text",
                    valueState = viewModel.decryptionPasswordState
                )

                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "",
                    supportingText = "Decrypted text",
                    valueState = viewModel.decryptedTextState,
                    readOnly = true
                )
            }
        }
    )
}