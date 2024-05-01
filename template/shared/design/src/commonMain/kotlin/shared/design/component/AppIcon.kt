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