package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.repository.PasscodeRepository

class UnlockPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(code: String): LockState {
        return repository.unlock(code)
    }

}