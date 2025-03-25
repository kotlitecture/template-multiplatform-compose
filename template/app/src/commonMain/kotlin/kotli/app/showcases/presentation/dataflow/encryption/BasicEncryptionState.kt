package kotli.app.showcases.presentation.dataflow.encryption

import androidx.compose.runtime.Stable

@Stable
interface BasicEncryptionState {

    val text: String
    val encryptedText: String
    val encryptionPassword: String
    val decryptedText: String
    val decryptionPassword: String

}