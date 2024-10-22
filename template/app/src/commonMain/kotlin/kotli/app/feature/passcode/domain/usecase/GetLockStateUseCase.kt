package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import kotlinx.coroutines.flow.Flow

class GetLockStateUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Flow<LockState> {
        return repository.getLockState()
    }

}