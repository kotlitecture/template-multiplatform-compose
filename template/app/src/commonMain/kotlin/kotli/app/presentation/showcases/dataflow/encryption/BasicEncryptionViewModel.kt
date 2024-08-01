package kotli.app.presentation.showcases.dataflow.encryption

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
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

    val pwdState = DataState<String>()
    val textState = DataState<String>()
    val encryptedTextState = DataState<String>()
    val decryptedTextState = DataState<String>()

    fun onBack() = navigationStore.onBack()

    override fun doBind() {
        // encryption
        launchAsync {
            pwdState.asFlow()
                .flatMapLatest { password ->
                    textState.asFlow().map { text -> Data(password, text) }
                }
                .debounce(300L)
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

        // decryption
        launchAsync {
            pwdState.asFlow()
                .flatMapLatest { password ->
                    encryptedTextState.asFlow().map { text -> Data(password, text) }
                }
                .debounce(300L)
                .map { data ->
                    val text = data.text
                    val password = data.password
                    if (password == null || text == null) {
                        null
                    } else {
                        val method = EncryptionMethod.AES(password)
                        runCatching { encryptionSource.decrypt(text, method) }
                            .getOrElse { th -> th.stackTraceToString() }
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
