package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.model.PasscodeState
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class GetPasscodeState(
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) : PasscodeUseCase() {

    suspend fun invoke(): PasscodeState? {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        return keyValueSource.read(key, strategy)
    }

}