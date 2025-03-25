package kotli.app.passcode.presentation.forgot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotli.app.common.presentation.loader.LoaderDialog
import kotlinx.coroutines.flow.filterNotNull
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.component.AppAlertDialog
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_forgot_message
import template.app.generated.resources.passcode_forgot_no
import template.app.generated.resources.passcode_forgot_title
import template.app.generated.resources.passcode_forgot_yes

@Composable
fun ForgotPasscodeDialog(onHide: () -> Unit) {
    val viewModel: ForgotPasscodeViewModel = provideViewModel()
    val state = viewModel.state

    LaunchedEffect(state) {
        snapshotFlow { state.event }.filterNotNull().collect { event ->
            when (event) {
                is ForgotPasscodeEvent.Complete -> onHide()
            }
        }
    }

    AppAlertDialog(
        dismissAction = onHide,
        onDismissRequest = onHide,
        confirmAction = viewModel::onConfirm,
        title = stringResource(Res.string.passcode_forgot_title),
        text = stringResource(Res.string.passcode_forgot_message),
        dismissLabel = stringResource(Res.string.passcode_forgot_no),
        confirmLabel = stringResource(Res.string.passcode_forgot_yes),
    )

    LoaderDialog(isLoading = state::loading)
}