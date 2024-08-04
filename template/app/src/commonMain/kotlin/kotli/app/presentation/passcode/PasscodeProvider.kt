package kotli.app.presentation.passcode

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PasscodeProvider() {
    provideViewModel<PasscodeViewModel>()
}