package shared.design.component

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Composable function for rendering a button commonly used in the app bars.
 *
 * @param modifier The modifier to be applied to the button.
 * @param onClick The callback to be invoked when the button is clicked.
 * @param icon The icon to be displayed on the button.
 * @param tint The color to tint the icon.
 */
@Composable
fun AppActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: Any?,
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