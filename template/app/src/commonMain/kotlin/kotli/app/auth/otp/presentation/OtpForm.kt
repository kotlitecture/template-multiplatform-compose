package kotli.app.auth.otp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.component.AppElevatedButton
import shared.presentation.ui.component.AppOutlinedButton
import shared.presentation.ui.component.AppSpacer16
import shared.presentation.ui.component.AppSpacer32
import shared.presentation.ui.component.AppSpacer4
import shared.presentation.ui.component.AppText
import shared.presentation.ui.component.AppTextButton
import shared.presentation.ui.component.AppTextField
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.auth_otp_action_resend
import template.app.generated.resources.auth_otp_action_verify
import template.app.generated.resources.auth_otp_placeholder

@Composable
fun OtpForm(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    onVerify: suspend (otp: String) -> Unit,
    onResend: suspend () -> Unit,
    onSuccess: () -> Unit
) {
    val viewModel: OtpViewModel = provideViewModel()
    val state = viewModel.state

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is OtpState.OnSuccess -> onSuccess()
            }
        },
        content = {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AppText(
                    text = title
                )

                AppSpacer4()

                AppText(
                    text = subTitle,
                    fontWeight = FontWeight.Bold,
                )

                AppSpacer32()

                AppTextField(
                    modifier = Modifier.fillMaxWidth(),
                    getValue = state::otp::get,
                    onValueChange = viewModel::onChangeOtp,
                    placeholder = stringResource(Res.string.auth_otp_placeholder),
                    autoFocus = true
                )

                AppSpacer16()

                AppElevatedButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.auth_otp_action_verify),
                    onClick = { viewModel.onVerify(onVerify) },
                    enabled = state.canVerify,
                )

                AppSpacer16()

                AppTextButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.auth_otp_action_resend),
                    onClick = { viewModel.onResend(onResend) }
                )
            }
        }
    )
}