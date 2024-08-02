package kotli.app.presentation.showcases.dataflow.encryption

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class BasicEncryptionViewModel(
    private val navigationStore: NavigationStore,
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    val textState = DataState<String>()
    val encryptedTextState = DataState<String>()
    val encryptionPasswordState = DataState<String>()

    val decryptedTextState = DataState<String>()
    val decryptionPasswordState = DataState<String>()

    fun onBack() = navigationStore.onBack()

    override fun doBind() {
        launchAsync("encryption") {
            encryptionPasswordState.asFlow()
                .flatMapLatest { password ->
                    textState.asFlow().map { text -> Data(password, text) }
                }
                .map { data ->
                    val text = data.text
                    val password = data.password
                    if (password == null || text == null) {
                        null
                    } else {
                        val method = EncryptionMethod.AES(password)
                        encryptionSource.encrypt(text, method)
                    }
                }
                .collectLatest(encryptedTextState::set)
        }

        launchAsync("decryption") {
            decryptionPasswordState.asFlow()
                .flatMapLatest { password ->
                    encryptedTextState.asFlow().map { text -> Data(password, text) }
                }
                .map { data ->
                    val text = data.text
                    val password = data.password
                    if (password == null || text == null) {
                        null
                    } else {
                        val method = EncryptionMethod.AES(password)
                        runCatching { encryptionSource.decrypt(text, method) }
                            .getOrElse { "Decryption error" }
                    }
                }
                .collectLatest(decryptedTextState::set)
        }
    }

    private data class Data(
        val password: String?,
        val text: String?
    )

}
