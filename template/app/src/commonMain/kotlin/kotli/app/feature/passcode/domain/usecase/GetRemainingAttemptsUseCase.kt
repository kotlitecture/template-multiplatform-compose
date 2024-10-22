package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository

class GetRemainingAttemptsUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Int {
        return repository.getRemainingUnlockAttempts()
    }

}