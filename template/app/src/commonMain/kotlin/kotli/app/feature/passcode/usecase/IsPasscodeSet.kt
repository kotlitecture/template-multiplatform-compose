package kotli.app.feature.passcode.usecase

import kotli.app.feature.passcode.common.domain.PasscodeRepository

class IsPasscodeSet(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Boolean {
        return repository.getPasscode() != null
    }

}