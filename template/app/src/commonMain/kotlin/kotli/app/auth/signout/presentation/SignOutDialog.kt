package kotli.app.auth.signout.presentation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.component.DsAlertDialog
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.auth_sign_out_cancel
import template.app.generated.resources.auth_sign_out_confirm
import template.app.generated.resources.auth_sign_out_message
import template.app.generated.resources.auth_sign_out_title

@Composable
fun SignOutDialog(
    onCancel: () -> Unit,
    onSuccess: () -> Unit,
) {
    val viewModel: SignOutViewModel = provideViewModel()
    val state = viewModel.state

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is SignOutState.OnSuccess -> onSuccess()
                else -> Unit
            }
        },
        content = {
            DsAlertDialog(
                dismissAction = onCancel,
                onDismissRequest = onCancel,
                confirmAction = viewModel::onConfirm,
                title = stringResource(Res.string.auth_sign_out_title),
                text = stringResource(Res.string.auth_sign_out_message),
                dismissLabel = stringResource(Res.string.auth_sign_out_cancel),
                confirmLabel = stringResource(Res.string.auth_sign_out_confirm),
            )
        }
    )
}