package kotli.app.feature.passcode.ui.unlock

import androidx.compose.runtime.Composable
import kotli.app.feature.passcode.ui.common.PadTextButton
import kotli.app.feature.passcode.ui.common.PasscodeKeyboard
import kotli.app.feature.passcode.ui.forgot.ForgotPasscodeDialog
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_unlock_forgot
import template.app.generated.resources.passcode_unlock_title

@Composable
fun UnlockPasscodeScreen() {
    val viewModel: UnlockPasscodeViewModel = provideViewModel()

    AppFixedTopBarColumn {
        PasscodeKeyboard(
            title = stringResource(Res.string.passcode_unlock_title),
            codeState = viewModel.enteredCodeState,
            codeLength = viewModel.passcodeLength,
            errorState = viewModel.errorStore,
            onCodeChange = viewModel::onUnlock,
            bottomLeftBlock = {
                PadTextButton(
                    text = stringResource(Res.string.passcode_unlock_forgot),
                    onClick = viewModel::onForgot
                )
            }
        )
    }

    ForgotPasscodeDialog(viewModel.forgotState)
}