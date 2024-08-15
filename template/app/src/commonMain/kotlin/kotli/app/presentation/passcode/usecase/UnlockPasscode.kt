package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotlinx.datetime.Clock
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource

class UnlockPasscode(
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke(code: String): LockState {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        val state = keyValueSource.read(key, strategy) ?: unknownError()

        val lock = try {
            check(passcodeStore.getRemainingUnlockAttempts() > 0) { unknownError() }

            val salt = state.salt
            val expectedCode = state.encodedCode
            val encryptionMethod = passcodeStore.encryptionMethod(salt)
            val actualCode = encryptionSource.encrypt(code, encryptionMethod)
            check(actualCode == expectedCode) { unknownError() }

            val nextState = state.copy(
                unlockAttempts = 0,
                unlockTime = Clock.System.now().toEpochMilliseconds()
            )
            keyValueSource.save(key, nextState, strategy)
            passcodeStore.passcodeState.set(nextState)
            LockState.UNLOCKED
        } catch (e: Exception) {
            val nextState = state.copy(
                unlockAttempts = state.unlockAttempts + 1
            )
            keyValueSource.save(key, nextState, strategy)
            passcodeStore.passcodeState.set(nextState)
            LockState.LOCKED
        }

        return lock
    }

    private fun unknownError(): Nothing = error("unknown error")

}