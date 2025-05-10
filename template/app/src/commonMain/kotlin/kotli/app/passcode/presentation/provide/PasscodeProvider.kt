package kotli.app.passcode.presentation.provide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotli.app.passcode.domain.model.LockState
import kotli.app.passcode.presentation.unlock.UnlockPasscodeScreen
import shared.presentation.ui.theme.DsTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider(content: @Composable () -> Unit) {
    val viewModel: PasscodeViewModel = provideViewModel()
    val state = viewModel.state

    when (val lockState = state.lockState) {
        LockState.UNDEFINED -> UndefinedState()
        else -> {
            content()
            if (lockState == LockState.LOCKED) {
                UnlockPasscodeScreen()
            }
        }
    }
}

@Composable
private fun UndefinedState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DsTheme.current.surface)
    )
}