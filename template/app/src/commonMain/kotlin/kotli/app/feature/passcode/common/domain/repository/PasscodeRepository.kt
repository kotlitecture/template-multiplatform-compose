package kotli.app.feature.passcode.common.domain.repository

import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.common.domain.model.Passcode
import kotlinx.coroutines.flow.Flow

interface PasscodeRepository {

    suspend fun getPasscodeLength(): Int

    suspend fun getRemainingUnlockAttempts(): Int

    suspend fun getLockState(): Flow<LockState>

    suspend fun unlock(code: String): LockState

    suspend fun check(code: String): LockState

    suspend fun setPasscode(passcode: Passcode)

    suspend fun getPasscode(): Passcode?

    suspend fun lock(code: String)

    suspend fun reset()

}