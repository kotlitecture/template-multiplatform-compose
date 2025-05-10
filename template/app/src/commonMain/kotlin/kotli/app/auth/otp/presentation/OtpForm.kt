package kotli.app.auth.otp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.component.DsElevatedButton
import shared.presentation.ui.component.DsSpacer16
import shared.presentation.ui.component.DsSpacer32
import shared.presentation.ui.component.DsSpacer4
import shared.presentation.ui.component.DsText
import shared.presentation.ui.component.DsTextButton
import shared.presentation.ui.component.DsTextField
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
                DsText(
                    text = title
                )

                DsSpacer4()

                DsText(
                    text = subTitle,
                    fontWeight = FontWeight.Bold,
                )

                DsSpacer32()

                DsTextField(
                    modifier = Modifier.fillMaxWidth(),
                    getValue = state::otp::get,
                    onValueChange = viewModel::onChangeOtp,
                    placeholder = stringResource(Res.string.auth_otp_placeholder),
                    autoFocus = true
                )

                DsSpacer16()

                DsElevatedButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.auth_otp_action_verify),
                    onClick = { viewModel.onVerify(onVerify) },
                    enabled = state.canVerify,
                )

                DsSpacer16()

                DsTextButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.auth_otp_action_resend),
                    onClick = { viewModel.onResend(onResend) }
                )
            }
        }
    )
}