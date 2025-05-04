package shared.presentation.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    text: String,
    onClick: () -> Unit,
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
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
    icon: AppIconModel? = null,
    iconTint: Color = LocalContentColor.current
) {
    ElevatedButton(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = onClick,
        content = {
            if (icon != null) {
                AppIcon(
                    model = icon,
                    tint = iconTint
                )
                AppSpacer8()
            }
            AppText(text = text)
        }
    )
}

@Composable
@NonRestartableComposable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
    icon: AppIconModel? = null,
    iconTint: Color = LocalContentColor.current
) {
    OutlinedButton(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        content = {
            if (icon != null) {
                AppIcon(
                    model = icon,
                    tint = iconTint
                )
                AppSpacer8()
            }
            AppText(text = text)
        }
    )
}