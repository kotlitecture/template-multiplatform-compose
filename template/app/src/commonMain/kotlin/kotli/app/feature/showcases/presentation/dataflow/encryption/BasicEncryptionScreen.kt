package kotli.app.feature.showcases.presentation.dataflow.encryption

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
fun BasicEncryptionScreen(onBack: () -> Unit) {
    val viewModel: BasicEncryptionViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn(
        title = BasicEncryptionRoute.screen.label,
        onBack = onBack,
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
                    getValue = state::encryptionPassword,
                    onValueChange = viewModel::onEncryptionPasswordChanged
                )

                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "Enter text",
                    supportingText = "Text",
                    getValue = state::text,
                    onValueChange = viewModel::onTextChanged
                )
            }
            AppTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                placeholder = "",
                readOnly = true,
                supportingText = "This text is encrypted based on the entered password and text",
                getValue = state::encryptedText,
                onValueChange = viewModel::onEncryptedTextChanged
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
                    getValue = state::decryptionPassword,
                    onValueChange = viewModel::onDecryptionPasswordChanged
                )

                AppTextField(
                    modifier = Modifier.weight(1f),
                    placeholder = "",
                    readOnly = true,
                    supportingText = "Decrypted text",
                    getValue = state::decryptedText,
                    onValueChange = viewModel::onDecryptedTextChanged
                )
            }
        }
    )
}