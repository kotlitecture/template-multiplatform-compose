package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.model.LockState
import kotli.app.passcode.domain.repository.PasscodeRepository

class UnlockPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(code: String): LockState {
        return repository.unlock(code)
    }

}