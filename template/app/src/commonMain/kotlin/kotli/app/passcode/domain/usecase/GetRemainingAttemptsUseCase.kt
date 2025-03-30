package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.repository.PasscodeRepository

class GetRemainingAttemptsUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Int {
        return repository.getRemainingUnlockAttempts()
    }

}