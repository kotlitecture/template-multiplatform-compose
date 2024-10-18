package kotli.app.feature.passcode.provider.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.feature.passcode.common.domain.LockState
import kotli.app.feature.passcode.provider.domain.GetPasscodeUseCase
import kotli.app.feature.passcode.provider.domain.UpdatePasscodeUseCase
import kotlinx.coroutines.flow.collectLatest
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val getPasscode: GetPasscodeUseCase,
    private val pausePasscode: UpdatePasscodeUseCase
) : BaseViewModel() {

    private val _state = PasscodeMutableState()
    val state: PasscodeState = _state

    override fun doInit() = init()

    override fun doResume() = init()

    override fun doPause() = async("Pause passcode") {
        pausePasscode.invoke()
    }

    private fun init() = async("Init passcode", true) {
        getPasscode.invoke().collectLatest { lockState ->
            _state.lockState = lockState
        }
    }

    private class PasscodeMutableState : PasscodeState {
        override var lockState: LockState by mutableStateOf(LockState.UNDEFINED)
    }

}
