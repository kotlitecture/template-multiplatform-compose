package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class ForgotPasscode(
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke() {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        keyValueSource.remove(key, strategy)

        passcodeStore.lockState.set(LockState.UNLOCKED)
        passcodeStore.passcodeState.clear()

        keyValueSource.clear()
    }

}