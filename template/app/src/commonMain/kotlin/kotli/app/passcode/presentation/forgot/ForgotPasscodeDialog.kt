package kotli.app.passcode.presentation.forgot

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.component.DsAlertDialog
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

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is ForgotPasscodeState.OnComplete -> onHide()
            }
        },
        content = {
            DsAlertDialog(
                dismissAction = onHide,
                onDismissRequest = onHide,
                confirmAction = viewModel::onConfirm,
                title = stringResource(Res.string.passcode_forgot_title),
                text = stringResource(Res.string.passcode_forgot_message),
                dismissLabel = stringResource(Res.string.passcode_forgot_no),
                confirmLabel = stringResource(Res.string.passcode_forgot_yes),
            )
        }
    )
}