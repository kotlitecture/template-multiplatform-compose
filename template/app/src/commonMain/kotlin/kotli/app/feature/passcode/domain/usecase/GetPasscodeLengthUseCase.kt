package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository

class GetPasscodeLengthUseCase(
    private val repository: PasscodeRepository
) {

    fun invoke(): Int {
        return repository.getPasscodeLength()
    }

}