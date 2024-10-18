package kotli.app.feature.passcode.provider.domain

import kotli.app.feature.passcode.common.domain.LockState
import kotli.app.feature.passcode.common.domain.PasscodeRepository
import kotlinx.coroutines.flow.Flow

class GetPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(): Flow<LockState> {
        return repository.getLockState()
    }

}