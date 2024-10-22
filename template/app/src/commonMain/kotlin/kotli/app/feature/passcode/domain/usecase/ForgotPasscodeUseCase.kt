package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import shared.data.source.keyvalue.KeyValueSource

class ForgotPasscodeUseCase(
    private val repository: PasscodeRepository,
    private val keyValueSource: KeyValueSource,
) {

    suspend fun invoke() {
        keyValueSource.clear()
        repository.reset()
    }

}