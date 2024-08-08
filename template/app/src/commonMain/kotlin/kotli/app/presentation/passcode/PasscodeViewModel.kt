package kotli.app.presentation.passcode

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.GetPasscodeState
import kotli.app.presentation.passcode.usecase.IsPasscodeExpired
import kotli.app.presentation.passcode.usecase.UpdatePasscodeState
import kotlinx.datetime.Clock
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val updatePasscodeState: UpdatePasscodeState,
    private val isPasscodeExpired: IsPasscodeExpired,
    private val getPasscodeState: GetPasscodeState,
    private val passcodeStore: PasscodeStore,
) : BaseViewModel() {

    override fun doBind() {
        launchAsync("getPasscodeState") {
            val state = getPasscodeState.invoke()
            passcodeStore.passcodeState.set(state)
        }
    }

    override fun doResume() {
        val state = passcodeStore.passcodeState.get() ?: return

        launchAsync("isPasscodeExpired") {
            val expired = isPasscodeExpired.invoke(state)
            if (expired) {
                // TODO
            }
        }
    }

    override fun doPause() {
        val state = passcodeStore.passcodeState.get() ?: return
        val newState = state.copy(unlockTime = Clock.System.now().toEpochMilliseconds())

        launchAsync("updatePasscodeState") {
            updatePasscodeState.invoke(newState)
        }
    }

}
