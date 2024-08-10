package kotli.app.presentation.passcode.ui.set.enter

import androidx.compose.runtime.Composable
import kotli.app.presentation.passcode.ui.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_enter_title

@Composable
fun EnterPasscodeScreen() {
    val viewModel: EnterPasscodeViewModel = provideViewModel()
    AppFixedTopBarColumn(
        onBack = viewModel::onBack
    ) {
        PasscodeKeyboard(
            title = stringResource(Res.string.passcode_enter_title),
            codeState = viewModel.enteredCodeState,
            codeLength = viewModel.passcodeLength,
            onCodeChange = viewModel::onEnter
        )
    }
}