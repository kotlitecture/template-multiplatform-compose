package kotli.app.feature.passcode.provide.presentation

import androidx.compose.runtime.Stable
import kotli.app.feature.passcode.common.domain.model.LockState

@Stable
interface PasscodeState {

    val lockState: LockState

}