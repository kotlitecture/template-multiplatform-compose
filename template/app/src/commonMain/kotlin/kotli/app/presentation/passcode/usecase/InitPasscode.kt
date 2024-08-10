package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotlinx.datetime.Clock
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class InitPasscode(
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke(): LockState {
        val key = passcodeStore.persistentKey
        val resumeTimeout = passcodeStore.resumeTimeout
        val currentTime = Clock.System.now().toEpochMilliseconds()
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        val passcode = keyValueSource.read(key, strategy)
        val lock = when {
            passcode == null -> LockState.UNLOCKED
            currentTime - passcode.unlockTime > resumeTimeout -> LockState.LOCKED
            else -> LockState.UNLOCKED
        }

        passcodeStore.passcodeState.set(passcode)
        passcodeStore.lockState.set(lock)

        return lock
    }

}