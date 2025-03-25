package kotli.app.showcases.presentation.dataflow.encryption

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource
import shared.presentation.viewmodel.BaseViewModel

class BasicEncryptionViewModel(
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    private val _state = BasicEncryptionMutableState()
    val state: BasicEncryptionState = _state

    override fun doBind() {
        val encryptionPasswordFlow = snapshotFlow { _state.encryptionPassword }
        val decryptionPasswordFlow = snapshotFlow { _state.decryptionPassword }
        val encryptedTextFlow = snapshotFlow { _state.encryptedText }
        val textFlow = snapshotFlow { _state.text }

        async("Encryption") {
            combine(encryptionPasswordFlow, textFlow) { password, text ->
                if (password.isEmpty() || text.isEmpty()) {
                    ""
                } else {
                    val method = EncryptionMethod.AES(password)
                    encryptionSource.encrypt(text, method)
                }
            }.collectLatest(_state::encryptedText::set)
        }

        async("Decryption") {
            combine(decryptionPasswordFlow, encryptedTextFlow) { password, text ->
                if (password.isEmpty() || text.isEmpty()) {
                    ""
                } else {
                    val method = EncryptionMethod.AES(password)
                    runCatching { encryptionSource.decrypt(text, method) }
                        .getOrElse { "Decryption error" }
                }
            }.collectLatest(_state::decryptedText::set)
        }
    }

    fun onEncryptionPasswordChanged(text: String) {
        _state.encryptionPassword = text
    }

    fun onDecryptionPasswordChanged(text: String) {
        _state.decryptionPassword = text
    }

    fun onEncryptedTextChanged(text: String) {
        _state.encryptedText = text
    }

    fun onDecryptedTextChanged(text: String) {
        _state.decryptedText = text
    }

    fun onTextChanged(text: String) {
        _state.text = text
    }

    private class BasicEncryptionMutableState : BasicEncryptionState {
        override var text: String by mutableStateOf("")
        override var encryptedText: String by mutableStateOf("")
        override var encryptionPassword: String by mutableStateOf("")
        override var decryptedText: String by mutableStateOf("")
        override var decryptionPassword: String by mutableStateOf("")
    }
}
