package kotli.app.feature.passcode.usecase

import kotli.app.feature.passcode.common.domain.PasscodeRepository

class ResetPasscode(
    private val repository: PasscodeRepository
) {

    suspend fun invoke() {
        repository.reset()
    }
}