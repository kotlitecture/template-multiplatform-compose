package kotli.app.feature.passcode.usecase

import kotli.app.feature.passcode.common.domain.PasscodeRepository

class SetPasscode(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(code: String) {
        repository.lock(code)
    }

}