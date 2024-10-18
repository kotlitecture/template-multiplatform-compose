package kotli.app.feature.passcode.common.domain.usecase

import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository
import kotlinx.coroutines.flow.Flow

class GetLockStateUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Flow<LockState> {
        return repository.getLockState()
    }

}