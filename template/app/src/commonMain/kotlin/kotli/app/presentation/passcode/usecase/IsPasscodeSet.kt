package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.PasscodeState
import kotli.app.presentation.passcode.model.PasscodeStore
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class IsPasscodeSet(
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) {

    suspend fun invoke(): Boolean {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())
        val passcode = keyValueSource.read(key, strategy)

        return passcode != null
    }

}