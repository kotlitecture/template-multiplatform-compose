package kotli.app.feature.passcode.ui.reset

import androidx.compose.runtime.Composable
import kotli.app.feature.passcode.ui.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_reset_title

@Composable
fun ResetPasscodeScreen() {
    val viewModel: ResetPasscodeViewModel = provideViewModel()
    AppFixedTopBarColumn(
        onBack = viewModel::onBack
    ) {
        PasscodeKeyboard(
            title = stringResource(Res.string.passcode_reset_title),
            codeState = viewModel.enteredCodeState,
            codeLength = viewModel.passcodeLength,
            errorState = viewModel.errorStore,
            onCodeChange = viewModel::onReset
        )
    }
}