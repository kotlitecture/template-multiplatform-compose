package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository

class SetPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(code: String) {
        repository.lock(code)
    }

}