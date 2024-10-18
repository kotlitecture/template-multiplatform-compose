package kotli.app.feature.passcode.provide.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotli.app.feature.passcode.common.domain.model.LockState
import kotli.app.feature.passcode.unlock.presentation.UnlockPasscodeScreen
import shared.design.theme.AppTheme
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
            .background(AppTheme.current.surface)
    )
}