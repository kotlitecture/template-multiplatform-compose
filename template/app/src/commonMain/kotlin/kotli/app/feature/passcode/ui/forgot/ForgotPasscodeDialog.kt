package kotli.app.feature.passcode.ui.forgot

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import shared.design.component.AppAlertDialog
import shared.presentation.store.DataState
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_forgot_message
import template.app.generated.resources.passcode_forgot_no
import template.app.generated.resources.passcode_forgot_title
import template.app.generated.resources.passcode_forgot_yes

@Composable
fun ForgotPasscodeDialog(state: DataState<Boolean>) {
    if (state.asStateValue() != true) return

    val viewModel: ForgotPasscodeViewModel = provideViewModel()

    AppAlertDialog(
        onDismissRequest = { state.set(false) },
        title = stringResource(Res.string.passcode_forgot_title),
        text = stringResource(Res.string.passcode_forgot_message),
        confirmLabel = stringResource(Res.string.passcode_forgot_yes),
        dismissLabel = stringResource(Res.string.passcode_forgot_no),
        confirmAction = { viewModel.onConfirm(state) },
        dismissAction = { state.set(false) }
    )
}