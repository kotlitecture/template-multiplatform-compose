package kotli.app.feature.passcode.set.presentation

import androidx.compose.runtime.Composable
import kotli.app.feature.passcode.common.presentation.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun SetPasscodeScreen(
    onBack: () -> Unit
) {
    val viewModel: SetPasscodeViewModel = provideViewModel()
    val state = viewModel.state
    val step = state.step ?: return

    AppFixedTopBarColumn(
        onBack = onBack
    ) {
        PasscodeKeyboard(
            onCodeChange = { code -> viewModel.onEnter(code, onBack) },
            title = stringResource(step.titleRes),
            codeLength = state.passcodeLength,
            getCode = state::enteredCode,
            getError = state::error,
        )
    }
}