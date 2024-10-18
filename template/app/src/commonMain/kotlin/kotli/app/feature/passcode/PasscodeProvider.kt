package kotli.app.feature.passcode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotli.app.feature.passcode.model.LockState
import kotli.app.feature.passcode.ui.unlock.UnlockPasscodeScreen
import shared.design.theme.AppTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider(content: @Composable () -> Unit) {
    val viewModel: PasscodeViewModel = provideViewModel()

    when (val state = viewModel.lockState.asStateValueNotNull()) {
        LockState.UNDEFINED -> UndefinedState()
        else -> {
            content()
            if (state == LockState.LOCKED) {
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