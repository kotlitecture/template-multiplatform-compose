package kotli.app.presentation.passcode

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.InitPasscode
import kotli.app.presentation.passcode.usecase.PausePasscode
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val initPasscode: InitPasscode,
    private val pausePasscode: PausePasscode,
    passcodeStore: PasscodeStore,
) : BaseViewModel() {

    val lockState = passcodeStore.lockState

    override fun doBind() {
        launchAsync("Init passcode") {
            initPasscode.invoke()
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
