package kotli.app.feature.passcode.reset.presentation

import androidx.compose.runtime.Composable
import kotli.app.feature.passcode.common.presentation.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_reset_title

@Composable
fun ResetPasscodeScreen(onBack: () -> Unit) {
    val viewModel: ResetPasscodeViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn(onBack = onBack) {
        PasscodeKeyboard(
            getError = state::error,
            getCode = state::enteredCode,
            codeLength = state.passcodeLength,
            title = stringResource(Res.string.passcode_reset_title),
            onCodeChange = { code -> viewModel.onReset(code, onBack) }
        )
    }
}