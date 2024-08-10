package kotli.app.presentation.passcode.ui.set.confirm

import androidx.compose.runtime.Composable
import kotli.app.presentation.passcode.ui.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_confirm_error
import template.app.generated.resources.passcode_confirm_title

@Composable
fun ConfirmPasscodeScreen(data: ConfirmPasscodeDestination.Data) {
    val viewModel: ConfirmPasscodeViewModel = provideViewModel()

    AppFixedTopBarColumn(
        onBack = viewModel::onBack
    ) {
        val error = stringResource(Res.string.passcode_confirm_error)
        PasscodeKeyboard(
            title = stringResource(Res.string.passcode_confirm_title),
            codeState = viewModel.enteredCodeState,
            errorState = viewModel.errorStore,
            codeLength = data.code.length,
            onCodeChange = { code -> viewModel.onConfirm(data.code, code, error) }
        )
    }
}