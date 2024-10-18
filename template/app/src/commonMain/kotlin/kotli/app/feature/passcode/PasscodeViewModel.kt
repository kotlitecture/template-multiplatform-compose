package kotli.app.feature.passcode

import kotli.app.feature.passcode.model.LockState
import kotli.app.feature.passcode.model.PasscodeStore
import kotli.app.feature.passcode.ui.unlock.UnlockPasscodeDestination
import kotli.app.feature.passcode.usecase.InitPasscode
import kotli.app.feature.passcode.usecase.PausePasscode
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val initPasscode: InitPasscode,
    private val pausePasscode: PausePasscode,
    private val navigationStore: NavigationStore,
    val passcodeStore: PasscodeStore,
) : BaseViewModel() {

    val lockState = passcodeStore.lockState

    override fun doInit() = async("Init passcode") {
        val lock = initPasscode.invoke()
        if (lock == LockState.LOCKED) {
            navigationStore.currentDestinationState.set(UnlockPasscodeDestination)
        }
    }

    override fun doResume() = async("Resume passcode") {
        initPasscode.invoke()
    }

    override fun doPause() = async("Pause passcode") {
        pausePasscode.invoke()
    }

}
