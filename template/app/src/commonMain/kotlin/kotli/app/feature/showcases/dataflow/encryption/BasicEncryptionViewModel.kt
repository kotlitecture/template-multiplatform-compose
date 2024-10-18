package kotli.app.feature.showcases.dataflow.encryption

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class BasicEncryptionViewModel(
    private val navigationStore: NavigationStore,
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    val textState = mutableStateOf("")
    val encryptedTextState = mutableStateOf("")
    val encryptionPasswordState = mutableStateOf("")

    val decryptedTextState = mutableStateOf("")
    val decryptionPasswordState = mutableStateOf("")

    fun onBack() = navigationStore.onBack()

    override fun doBind() {
        val encryptionPasswordFlow = snapshotFlow { encryptionPasswordState.value }
        val decryptionPasswordFlow = snapshotFlow { decryptionPasswordState.value }
        val encryptedTextFlow = snapshotFlow { encryptedTextState.value }
        val textFlow = snapshotFlow { textState.value }
        async("encryption") {
            encryptionPasswordFlow
                .flatMapLatest { password ->
                    textFlow.map { text -> Data(password, text) }
                }
                .map { data ->
                    val text = data.text
                    val password = data.password
                    if (password.isNullOrEmpty() || text.isNullOrEmpty()) {
                        ""
                    } else {
                        val method = EncryptionMethod.AES(password)
                        encryptionSource.encrypt(text, method)
                    }
                }
                .collectLatest(encryptedTextState::value::set)
        }

        async("decryption") {
            decryptionPasswordFlow
                .flatMapLatest { password ->
                    encryptedTextFlow.map { text -> Data(password, text) }
                }
                .map { data ->
                    val text = data.text
                    val password = data.password
                    if (password.isNullOrEmpty() || text.isNullOrEmpty()) {
                        ""
                    } else {
                        val method = EncryptionMethod.AES(password)
                        runCatching { encryptionSource.decrypt(text, method) }
                            .getOrElse { "Decryption error" }
                    }
                }
                .collectLatest(decryptedTextState::value::set)
        }
    }

    private data class Data(
        val password: String?,
        val text: String?
    )
}
