package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.PasscodeStore
import kotli.app.presentation.passcode.state.PasscodeState
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource

class SetPasscode(
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) : PasscodeUseCase() {

    suspend fun invoke(code: String): PasscodeState {
        val encryptionMethod = encryptionMethod(code)
        val encodedCode = encryptionSource.encrypt(code, encryptionMethod)

        val state = PasscodeState(encodedCode)
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        keyValueSource.save(key, state, strategy)

        return state
    }

}