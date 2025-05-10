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
import shared.presentation.ui.icon.DsIconModel

@Composable
@NonRestartableComposable
fun DsActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: DsIconModel?,
    tint: Color = LocalContentColor.current
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        content = {
            DsIcon(
                model = icon,
                tint = tint
            )
        }
    )
}

@Composable
@NonRestartableComposable
fun DsTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        DsText(text = text)
    }
}

@Composable
@NonRestartableComposable
fun DsElevatedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
    icon: DsIconModel? = null,
    iconTint: Color = LocalContentColor.current
) {
    ElevatedButton(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = onClick,
        content = {
            if (icon != null) {
                DsIcon(
                    model = icon,
                    tint = iconTint
                )
                DsSpacer8()
            }
            DsText(text = text)
        }
    )
}

@Composable
@NonRestartableComposable
fun DsOutlinedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
    icon: DsIconModel? = null,
    iconTint: Color = LocalContentColor.current
) {
    OutlinedButton(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        content = {
            if (icon != null) {
                DsIcon(
                    model = icon,
                    tint = iconTint
                )
                DsSpacer8()
            }
            DsText(text = text)
        }
    )
}