package kotli.app.auth.signin.email.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.component.DsOutlinedButton
import shared.presentation.ui.icon.DsIconModel
import template.app.generated.resources.Res
import template.app.generated.resources.auth_email
import template.app.generated.resources.auth_sign_in_email

@Composable
fun SignInWithEmailButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    DsOutlinedButton(
        modifier = modifier,
        icon = DsIconModel.DrawableResource(Res.drawable.auth_email),
        text = stringResource(Res.string.auth_sign_in_email),
        onClick = onClick,
    )
}