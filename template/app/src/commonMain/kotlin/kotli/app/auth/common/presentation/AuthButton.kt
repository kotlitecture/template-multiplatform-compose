package kotli.app.auth.common.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import shared.presentation.ui.component.AppOutlinedButton
import shared.presentation.ui.icon.DrawableResourceModel

@Composable
fun AuthButton(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    text: String,
    onClick: () -> Unit,
) {
    AppOutlinedButton(
        modifier = modifier,
        icon = DrawableResourceModel(icon),
        iconTint = Color.Unspecified,
        onClick = onClick,
        text = text
    )
}