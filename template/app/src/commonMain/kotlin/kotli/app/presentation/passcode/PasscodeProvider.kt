package kotli.app.presentation.passcode

import androidx.compose.runtime.Composable
import kotli.app.presentation.passcode.model.LockState
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider(content: @Composable () -> Unit) {
    val viewModel: PasscodeViewModel = provideViewModel()
    val state = viewModel.lockState.asStateValueNotNull()

    when (state) {
        LockState.UNDEFINED -> Unit
        LockState.UNLOCKED -> content()
        LockState.LOCKED -> {

        }
    }
}