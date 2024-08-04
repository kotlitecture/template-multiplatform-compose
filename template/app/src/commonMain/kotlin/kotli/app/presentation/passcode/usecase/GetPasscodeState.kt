package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.PasscodeStore
import kotli.app.presentation.passcode.state.PasscodeState
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class GetPasscodeState(
    private val keyValueSource: KeyValueSource,
    private val passcodeStore: PasscodeStore
) : PasscodeUseCase() {

    suspend operator fun invoke(): PasscodeState? {
        val key = passcodeStore.passcodeConfigKey
        val strategy = SerializationStrategy.json(PasscodeState.serializer())

        return keyValueSource.read(key, strategy)
    }

}