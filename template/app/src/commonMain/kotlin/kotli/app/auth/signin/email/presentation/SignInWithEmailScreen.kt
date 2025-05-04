package kotli.app.auth.signin.email.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.container.AppFixedTopBarLayout
import template.app.generated.resources.Res
import template.app.generated.resources.auth_sign_in_email

@Composable
fun SignInWithEmailScreen(
    modifier: Modifier = Modifier,
    onVerify: (email: String) -> Unit,
    onBack: () -> Unit,
) {
    AppFixedTopBarLayout(
        modifier = modifier,
        title = stringResource(Res.string.auth_sign_in_email),
        onBack = onBack,
        content = {
            SignInWithEmailForm(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onVerify = onVerify,
            )
        }
    )
}