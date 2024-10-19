package kotli.app.feature.passcode.presentation.provide

import androidx.compose.runtime.Stable
import kotli.app.feature.passcode.domain.model.LockState

@Stable
interface PasscodeState {

    val lockState: LockState

}