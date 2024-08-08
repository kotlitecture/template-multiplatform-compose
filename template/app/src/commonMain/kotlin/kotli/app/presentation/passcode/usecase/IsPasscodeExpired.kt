package kotli.app.presentation.passcode.usecase

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.model.PasscodeState
import kotlinx.datetime.Clock

class IsPasscodeExpired(
    private val passcodeStore: PasscodeStore
) : PasscodeUseCase() {

    fun invoke(state: PasscodeState): Boolean {
        val currentTime = Clock.System.now().toEpochMilliseconds()
        val unlockTime = state.unlockTime

        return currentTime - unlockTime > passcodeStore.resumeTimeout
    }

}