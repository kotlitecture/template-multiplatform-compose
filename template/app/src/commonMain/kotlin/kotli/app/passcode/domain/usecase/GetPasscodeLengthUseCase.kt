package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.repository.PasscodeRepository

class GetPasscodeLengthUseCase(
    private val repository: PasscodeRepository
) {

    fun invoke(): Int {
        return repository.getPasscodeLength()
    }

}