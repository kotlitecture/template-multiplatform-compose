package kotli.app.feature.passcode.presentation.provide

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.usecase.GetLockStateUseCase
import kotli.app.feature.passcode.domain.usecase.UpdatePasscodeUseCase
import kotlinx.coroutines.flow.collectLatest
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val getLockState: GetLockStateUseCase,
    private val updatePasscode: UpdatePasscodeUseCase
) : BaseViewModel() {

    private val _state = PasscodeMutableState()
    val state: PasscodeState = _state

    override fun doInit() = init()

    override fun doResume() = init()

    override fun doPause() = async("Pause passcode") {
        updatePasscode.invoke()
    }

    private fun init() = async("Init passcode", true) {
        getLockState.invoke().collectLatest { lockState ->
            _state.lockState = lockState
        }
    }

    private class PasscodeMutableState : PasscodeState {
        override var lockState: LockState by mutableStateOf(LockState.UNDEFINED)
    }

}
