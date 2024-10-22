package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import kotlinx.coroutines.flow.first
import kotlinx.datetime.Clock

class UpdatePasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke() {
        val passcode = repository.getPasscode() ?: return
        val lockState = repository.getLockState().first()
        if (lockState != LockState.UNLOCKED) return

        val currentTime = Clock.System.now().toEpochMilliseconds()
        val newPasscode = passcode.copy(unlockTime = currentTime)

        repository.setPasscode(newPasscode)
    }

}