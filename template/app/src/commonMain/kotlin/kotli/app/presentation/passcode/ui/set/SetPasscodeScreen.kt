package kotli.app.presentation.passcode.ui.set

import androidx.compose.runtime.Composable
import kotli.app.presentation.passcode.ui.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun SetPasscodeScreen() {
    val viewModel: SetPasscodeViewModel = provideViewModel()
    val state = viewModel.uiState.asStateValue() ?: return

    AppFixedTopBarColumn(
        onBack = viewModel::onBack
    ) {
        PasscodeKeyboard(
            title = stringResource(state.titleRes),
            codeState = viewModel.enteredCodeState,
            codeLength = viewModel.passcodeLength,
            errorState = viewModel.errorStore,
            onCodeChange = viewModel::onEnter
        )
    }
}