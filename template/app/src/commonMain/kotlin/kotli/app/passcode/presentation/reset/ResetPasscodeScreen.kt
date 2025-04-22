package kotli.app.passcode.presentation.reset

import androidx.compose.runtime.Composable
import kotli.app.passcode.presentation.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_reset_title

@Composable
fun ResetPasscodeScreen(onBack: () -> Unit) {
    val viewModel: ResetPasscodeViewModel = provideViewModel()
    val state = viewModel.state

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is ResetPasscodeState.OnComplete -> onBack()
            }
        },
        content = {
            AppFixedTopBarColumn(onBack = onBack) {
                PasscodeKeyboard(
                    getError = state::error,
                    getCode = state::enteredCode,
                    onCodeChange = viewModel::onReset,
                    codeLength = state.passcodeLength,
                    title = stringResource(Res.string.passcode_reset_title),
                )
            }
        }
    )
}