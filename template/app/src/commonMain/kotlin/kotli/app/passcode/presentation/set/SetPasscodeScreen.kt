package kotli.app.passcode.presentation.set

import androidx.compose.runtime.Composable
import kotli.app.passcode.presentation.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.container.DsFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun SetPasscodeScreen(
    onBack: () -> Unit
) {
    val viewModel: SetPasscodeViewModel = provideViewModel()
    val state = viewModel.state
    val step = state.step ?: return

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is SetPasscodeState.OnComplete -> onBack()
            }
        },
        content = {
            DsFixedTopBarColumn(
                onBack = onBack
            ) {
                PasscodeKeyboard(
                    onCodeChange = viewModel::onEnter,
                    title = stringResource(step.titleRes),
                    codeLength = state.passcodeLength,
                    getCode = state::enteredCode,
                    getError = state::error,
                )
            }
        }
    )
}