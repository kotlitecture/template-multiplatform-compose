package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.repository.PasscodeRepository

class ResetPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke() {
        repository.reset()
    }
}