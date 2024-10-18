package kotli.app.feature.passcode.usecase

import kotli.app.feature.passcode.model.LockState
import kotli.app.feature.passcode.model.PasscodeState
import kotli.app.feature.passcode.model.PasscodeStore
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