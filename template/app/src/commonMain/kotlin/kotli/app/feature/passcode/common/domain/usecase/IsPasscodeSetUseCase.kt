package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository

class IsPasscodeSetUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Boolean {
        return repository.getPasscode() != null
    }

}