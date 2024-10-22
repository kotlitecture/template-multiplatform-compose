package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository

class IsPasscodeSetUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Boolean {
        return repository.getPasscode() != null
    }

}