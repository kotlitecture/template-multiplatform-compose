package shared.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * Icon.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param tint Color to be applied to the icon.
 * @param size Size of the icon.
 * @param model Data model representing the icon.
 */
@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: Any?
) {
    when (model) {
        is ImageVector -> AppIcon(modifier, tint, size, model)
        is DrawableResource -> AppIcon(modifier, tint, size, model)
        is Color -> AppIcon(modifier, size, model)
        else -> Box(modifier = modifier.size(size).background(tint))
    }
}

/**
 * Icon from an ImageVector.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param tint Color to be applied to the icon.
 * @param size Size of the icon.
 * @param model ImageVector representing the icon.
 */
@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: ImageVector
) {
    Icon(
        modifier = modifier.size(size),
        contentDescription = null,
        imageVector = model,
        tint = tint
    )
}

/**
 * Icon from a DrawableResource.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param tint Color to be applied to the icon.
 * @param size Size of the icon.
 * @param model DrawableResource representing the icon.
 */
@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DrawableResource
) {
    Icon(
        modifier = modifier.size(size),
        painter = painterResource(model),
        contentDescription = null,
        tint = tint
    )
}

/**
 * Colored box as an icon.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param size Size of the icon.
 * @param model Color representing the icon.
 */
@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    model: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .background(model)
    )
}