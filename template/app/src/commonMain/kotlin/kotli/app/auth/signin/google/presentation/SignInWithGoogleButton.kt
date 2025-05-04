package kotli.app.auth.signin.google.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotli.app.auth.common.presentation.AuthButton
import org.jetbrains.compose.resources.stringResource
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.auth_google
import template.app.generated.resources.auth_sign_in_google

@Composable
fun SignInWithGoogleButton(
    modifier: Modifier = Modifier
) {
    val viewModel: SignInWithGoogleViewModel = provideViewModel()
    AuthButton(
        modifier = modifier,
        onClick = viewModel::onSignIn,
        text = stringResource(Res.string.auth_sign_in_google),
        icon = Res.drawable.auth_google
    )
}