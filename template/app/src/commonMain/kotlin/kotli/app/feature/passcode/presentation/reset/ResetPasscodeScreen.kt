package kotli.app.feature.passcode.presentation.reset

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotli.app.feature.passcode.presentation.common.PasscodeKeyboard
import kotlinx.coroutines.flow.filterNotNull
import org.jetbrains.compose.resources.stringResource
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_reset_title

@Composable
fun ResetPasscodeScreen(onBack: () -> Unit) {
    val viewModel: ResetPasscodeViewModel = provideViewModel()
    val state = viewModel.state

    LaunchedEffect(state) {
        snapshotFlow { state.event }.filterNotNull().collect { event ->
            when (event) {
                is ResetPasscodeEvent.Complete -> onBack()
            }
        }
    }

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