package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository

class GetRemainingAttemptsUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Int {
        return repository.getRemainingUnlockAttempts()
    }

}