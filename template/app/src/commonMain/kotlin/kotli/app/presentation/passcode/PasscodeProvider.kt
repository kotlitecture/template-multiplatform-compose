package kotli.app.presentation.passcode

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider(content: @Composable () -> Unit) {
    val viewModel: PasscodeViewModel = provideViewModel()
}