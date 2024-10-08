package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotlinx.datetime.Clock
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class PausePasscode(
    private val passcodeStore: PasscodeStore,
    private val keyValueSource: KeyValueSource
) {

    suspend fun invoke() {
        val state = passcodeStore.passcodeState.get() ?: return
        if (passcodeStore.lockState.getNotNull() != LockState.UNLOCKED) return

        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        val newState = state.copy(unlockTime = Clock.System.now().toEpochMilliseconds())

        keyValueSource.save(key, newState, strategy)
        passcodeStore.passcodeState.set(newState)
    }

}