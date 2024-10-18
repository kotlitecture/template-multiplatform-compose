package kotli.app.feature.passcode.unlock.domain

import kotli.app.feature.passcode.common.domain.PasscodeRepository

class GetPasscodeLengthUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Int {
        return repository.getPasscodeLength()
    }

}