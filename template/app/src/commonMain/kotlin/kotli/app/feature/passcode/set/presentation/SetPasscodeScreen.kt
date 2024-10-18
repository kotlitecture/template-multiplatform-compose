package kotli.app.feature.passcode.set.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotli.app.feature.passcode.common.presentation.PasscodeKeyboard
import kotlinx.coroutines.flow.filterNotNull
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

    LaunchedEffect(state) {
        snapshotFlow { state.event }.filterNotNull().collect { event ->
            when (event) {
                is SetPasscodeEvent.Complete -> onBack()
            }
        }
    }

    AppFixedTopBarColumn(
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