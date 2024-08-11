package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource

class ResetPasscode(
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke(currentCode: String): Boolean {
        val state = passcodeStore.passcodeState.get() ?: return true

        return try {
            val encodedCode = state.encodedCode
            val encryptionMethod = passcodeStore.encryptionMethod(currentCode)
            val decodedCode = encryptionSource.decrypt(encodedCode, encryptionMethod)
            val reset = decodedCode == currentCode

            if (reset) {
                val key = passcodeStore.persistentKey
                val strategy = SerializationStrategy.json(PasscodeState.serializer())
                keyValueSource.remove(key, strategy)
                passcodeStore.lockState.set(LockState.UNLOCKED)
                passcodeStore.passcodeState.clear()
            }

            reset
        } catch (e: Exception) {
            false
        }
    }
}