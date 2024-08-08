package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.model.PasscodeState
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class UpdatePasscodeState(
    private val passcodeStore: PasscodeStore,
    private val keyValueSource: KeyValueSource
) : PasscodeUseCase() {

    suspend fun invoke(state: PasscodeState?) {
        val key = passcodeStore.persistentKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        keyValueSource.save(key, state, strategy)
    }

}