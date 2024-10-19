package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository

class ResetPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke() {
        repository.reset()
    }
}