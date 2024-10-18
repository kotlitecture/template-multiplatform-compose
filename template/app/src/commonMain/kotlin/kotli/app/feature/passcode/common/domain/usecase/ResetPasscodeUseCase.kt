package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository

class ResetPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke() {
        repository.reset()
    }
}