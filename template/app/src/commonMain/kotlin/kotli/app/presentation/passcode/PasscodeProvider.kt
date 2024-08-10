package kotli.app.presentation.passcode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotli.app.presentation.loader.LoaderProvider
import kotli.app.presentation.passcode.model.LockState
import kotli.app.presentation.passcode.ui.unlock.UnlockPasscodeScreen
import shared.design.theme.AppTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider(content: @Composable () -> Unit) {
    val viewModel: PasscodeViewModel = provideViewModel()
    val state = viewModel.lockState.asStateValueNotNull()

    when (state) {
        LockState.UNLOCKED -> content()
        LockState.LOCKED -> UnlockPasscodeScreen()
        LockState.UNDEFINED -> UndefinedState()
    }

    LoaderProvider(viewModel.passcodeStore)
}

@Composable
private fun UndefinedState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.current.surface)
    )
}