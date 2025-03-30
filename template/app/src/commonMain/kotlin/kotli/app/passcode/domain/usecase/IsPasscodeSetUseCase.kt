package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.repository.PasscodeRepository

class IsPasscodeSetUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Boolean {
        return repository.getPasscode() != null
    }

}