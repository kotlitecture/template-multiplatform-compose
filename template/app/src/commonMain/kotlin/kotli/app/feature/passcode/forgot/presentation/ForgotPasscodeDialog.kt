package kotli.app.feature.passcode.forgot.presentation

import androidx.compose.runtime.Composable
import kotli.app.common.presentation.loader.LoaderDialog
import org.jetbrains.compose.resources.stringResource
import shared.design.component.AppAlertDialog
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_forgot_message
import template.app.generated.resources.passcode_forgot_no
import template.app.generated.resources.passcode_forgot_title
import template.app.generated.resources.passcode_forgot_yes

@Composable
fun ForgotPasscodeDialog(onHide: () -> Unit) {
    val viewModel: ForgotPasscodeViewModel = provideViewModel()

    AppAlertDialog(
        dismissAction = onHide,
        onDismissRequest = onHide,
        confirmAction = { viewModel.onConfirm(onHide) },
        title = stringResource(Res.string.passcode_forgot_title),
        text = stringResource(Res.string.passcode_forgot_message),
        dismissLabel = stringResource(Res.string.passcode_forgot_no),
        confirmLabel = stringResource(Res.string.passcode_forgot_yes),
    )

    LoaderDialog(isLoading = viewModel.state::loading)
}