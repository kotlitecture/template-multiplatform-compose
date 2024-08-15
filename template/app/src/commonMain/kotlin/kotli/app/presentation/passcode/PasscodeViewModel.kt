package kotli.app.presentation.passcode

import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.ui.unlock.UnlockPasscodeDestination
import kotli.app.presentation.passcode.usecase.InitPasscode
import kotli.app.presentation.passcode.usecase.PausePasscode
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val initPasscode: InitPasscode,
    private val pausePasscode: PausePasscode,
    private val navigationStore: NavigationStore,
    val passcodeStore: PasscodeStore,
) : BaseViewModel() {

    val lockState = passcodeStore.lockState

    override fun doInit() {
        launchAsync("Init passcode") {
            val lock = initPasscode.invoke()
            if (lock == LockState.LOCKED) {
                navigationStore.currentDestinationState.set(UnlockPasscodeDestination)
            }
        }
    }

    override fun doResume() {
        launchAsync("Resume passcode") {
            initPasscode.invoke()
        }
    }

    override fun doPause() {
        launchAsync("Pause passcode") {
            pausePasscode.invoke()
        }
    }

}
