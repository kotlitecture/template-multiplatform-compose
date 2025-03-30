package shared.presentation.ui.component

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.presentation.ui.icon.AppIconModel

@Composable
@NonRestartableComposable
fun AppActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: AppIconModel?,
    tint: Color = LocalContentColor.current
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        content = {
            AppIcon(
                model = icon,
                tint = tint
            )
        }
    )
}

@Composable
@NonRestartableComposable
fun AppTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        AppText(text = text)
    }
}

@Composable
@NonRestartableComposable
fun AppElevatedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        content = { AppText(text = text) }
    )
}

@Composable
@NonRestartableComposable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        content = { AppText(text = text) }
    )
}