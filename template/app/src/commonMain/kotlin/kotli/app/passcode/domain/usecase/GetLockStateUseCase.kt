package kotli.app.passcode.domain.usecase

import kotli.app.passcode.domain.model.LockState
import kotli.app.passcode.domain.repository.PasscodeRepository
import kotlinx.coroutines.flow.Flow

class GetLockStateUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Flow<LockState> {
        return repository.getLockState()
    }

}