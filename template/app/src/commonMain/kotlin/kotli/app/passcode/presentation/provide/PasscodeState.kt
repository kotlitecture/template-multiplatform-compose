package kotli.app.passcode.presentation.provide

import androidx.compose.runtime.Stable
import kotli.app.passcode.domain.model.LockState

@Stable
interface PasscodeState {

    val lockState: LockState

}