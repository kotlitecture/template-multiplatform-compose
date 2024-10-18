package kotli.app.feature.passcode.forgot.domain

import kotli.app.feature.passcode.common.domain.PasscodeRepository
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