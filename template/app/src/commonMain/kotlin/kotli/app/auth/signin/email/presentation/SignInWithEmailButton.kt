package kotli.app.auth.signin.email.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.component.AppOutlinedButton
import shared.presentation.ui.icon.DrawableResourceModel
import template.app.generated.resources.Res
import template.app.generated.resources.auth_email
import template.app.generated.resources.auth_sign_in_email

@Composable
fun SignInWithEmailButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    AppOutlinedButton(
        modifier = modifier,
        icon = DrawableResourceModel(Res.drawable.auth_email),
        onClick = onClick,
        text = stringResource(Res.string.auth_sign_in_email)
    )
}