package kotli.app.feature.passcode.provider.presentation

import androidx.compose.runtime.Stable
import kotli.app.feature.passcode.common.domain.LockState

@Stable
interface PasscodeState {

    val lockState: LockState

}