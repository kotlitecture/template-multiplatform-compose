package kotli.app.passcode.presentation.unlock

import androidx.compose.runtime.Composable
import kotli.app.common.presentation.loader.LoaderDialog
import kotli.app.passcode.presentation.common.PadTextButton
import kotli.app.passcode.presentation.common.PasscodeKeyboard
import kotli.app.passcode.presentation.forgot.ForgotPasscodeDialog
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_forgot
import template.app.generated.resources.passcode_unlock_title

@Composable
fun UnlockPasscodeScreen() {
    val viewModel: UnlockPasscodeViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn {
        PasscodeKeyboard(
            title = stringResource(Res.string.passcode_unlock_title),
            onCodeChange = viewModel::onUnlock,
            codeLength = state.passcodeLength,
            getCode = state::enteredCode,
            getError = state::error,
            bottomLeftBlock = {
                PadTextButton(
                    text = stringResource(Res.string.passcode_unlock_forgot),
                    onClick = viewModel::onForgot
                )
            }
        )
    }

    ForgotBlock(state, viewModel::onCancelForgot)
    LoaderDialog(state::loading)
}

@Composable
private fun ForgotBlock(
    state: UnlockPasscodeState,
    onHide: () -> Unit
) {
    if (state.forgot) {
        ForgotPasscodeDialog(onHide)
    }
}