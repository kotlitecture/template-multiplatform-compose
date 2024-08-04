package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.PasscodeStore
import kotli.app.presentation.passcode.state.PasscodeState
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class UpdatePasscodeState(
    private val passcodeStore: PasscodeStore,
    private val keyValueSource: KeyValueSource
) : PasscodeUseCase() {

    suspend operator fun invoke(state: PasscodeState?) {
        val key = passcodeStore.passcodeConfigKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        keyValueSource.save(key, state, strategy)
    }

}