package shared.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import shared.design.icon.AppIconModel
import shared.design.icon.ColorModel
import shared.design.icon.DrawableResourceModel
import shared.design.icon.ImageVectorModel
import shared.design.icon.PainterModel
import shared.design.icon.UrlModel

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
    model: AppIconModel?
) {
    when (model) {
        is UrlModel -> AppIcon(modifier, size, model)
        is ColorModel -> AppIcon(modifier, size, model)
        is PainterModel -> AppIcon(modifier, tint, size, model)
        is ImageVectorModel -> AppIcon(modifier, tint, size, model)
        is DrawableResourceModel -> AppIcon(modifier, tint, size, model)
        else -> Box(modifier = modifier.size(size).background(tint))
    }
}

/**
 * Icon from an Painter.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param tint Color to be applied to the icon.
 * @param size Size of the icon.
 * @param model ImageVector representing the icon.
 */
@Composable
@NonRestartableComposable
private fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: PainterModel
) {
    Icon(
        modifier = modifier.size(size),
        contentDescription = null,
        painter = model.value(),
        tint = tint
    )
}

// {userflow.coil}
/**
 * Icon from an http url.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param size Size of the icon.
 * @param model http url representing the icon.
 */
@Composable
@NonRestartableComposable
private fun AppIcon(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    model: UrlModel
) {
    Image(
        painter = rememberAsyncImagePainter(model.value),
        modifier = modifier.size(size),
        contentDescription = null
    )
}
// {userflow.coil}

/**
 * Icon from an ImageVector.
 *
 * @param modifier Modifier to be applied to the icon.
 * @param tint Color to be applied to the icon.
 * @param size Size of the icon.
 * @param model ImageVector representing the icon.
 */
@Composable
@NonRestartableComposable
private fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: ImageVectorModel
) {
    Icon(
        modifier = modifier.size(size),
        contentDescription = null,
        imageVector = model.value,
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
@NonRestartableComposable
private fun AppIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DrawableResourceModel
) {
    Icon(
        modifier = modifier.size(size),
        painter = painterResource(model.value),
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
@NonRestartableComposable
private fun AppIcon(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    model: ColorModel
) {
    Box(
        modifier = modifier
            .size(size)
            .background(model.value)
    )
}