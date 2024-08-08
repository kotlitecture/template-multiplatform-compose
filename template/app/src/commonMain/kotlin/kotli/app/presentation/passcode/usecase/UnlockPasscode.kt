package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.model.PasscodeState
import kotlinx.datetime.Clock
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource

class UnlockPasscode(
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) : PasscodeUseCase() {

    suspend fun invoke(code: String): PasscodeState {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        val state = keyValueSource.read(key, strategy) ?: unknownError()

        val nextState = runCatching {
            val encodedCode = state.encodedCode
            val encryptionMethod = encryptionMethod(code)

            val decodedCode = encryptionSource.decrypt(encodedCode, encryptionMethod)
            check(decodedCode == code) { unknownError() }

            state.copy(
                unlockAttempts = 0,
                decodedCode = decodedCode,
                unlockTime = Clock.System.now().toEpochMilliseconds()
            )
        }.getOrElse {
            state.copy(
                decodedCode = null,
                unlockAttempts = state.unlockAttempts + 1
            )
        }

        keyValueSource.save(key, nextState, strategy)

        return nextState
    }

}