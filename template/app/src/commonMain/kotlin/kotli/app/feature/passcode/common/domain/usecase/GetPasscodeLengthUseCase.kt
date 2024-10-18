package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository

class GetPasscodeLengthUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Int {
        return repository.getPasscodeLength()
    }

}