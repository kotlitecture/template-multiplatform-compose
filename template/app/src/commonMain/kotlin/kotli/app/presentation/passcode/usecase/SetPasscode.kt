package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotlinx.datetime.Clock
import shared.data.serialization.ByteArrayStrategy
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource
import kotlin.random.Random

class SetPasscode(
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke(code: String) {
        val salt = ByteArrayStrategy.toString(Random.nextBytes(16))
        val encryptionMethod = passcodeStore.encryptionMethod(salt)
        val encodedCode = encryptionSource.encrypt(code, encryptionMethod)

        val state = PasscodeState(
            unlockTime = Clock.System.now().toEpochMilliseconds(),
            encodedCode = encodedCode,
            unlockAttempts = 0,
            salt = salt
        )
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        keyValueSource.save(key, state, strategy)

        passcodeStore.lockState.set(LockState.UNLOCKED)
        passcodeStore.passcodeState.set(state)
    }

}