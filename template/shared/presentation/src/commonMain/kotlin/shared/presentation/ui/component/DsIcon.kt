package shared.presentation.ui.component

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
import shared.presentation.ui.icon.DsIconModel

@Composable
fun DsIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DsIconModel?
) {
    when (model) {
        is DsIconModel.Url -> DsIcon(modifier, size, model)
        is DsIconModel.Color -> DsIcon(modifier, size, model)
        is DsIconModel.Painter -> DsIcon(modifier, tint, size, model)
        is DsIconModel.ImageVector -> DsIcon(modifier, tint, size, model)
        is DsIconModel.DrawableResource -> DsIcon(modifier, tint, size, model)
        else -> Box(modifier = modifier.size(size).background(tint))
    }
}

@Composable
@NonRestartableComposable
private fun DsIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DsIconModel.Painter
) {
    Icon(
        modifier = modifier.size(size),
        contentDescription = null,
        painter = model.value(),
        tint = tint
    )
}

// {userflow.coil}
@Composable
@NonRestartableComposable
private fun DsIcon(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    model: DsIconModel.Url
) {
    Image(
        painter = rememberAsyncImagePainter(model.value),
        modifier = modifier.size(size),
        contentDescription = null
    )
}

// {userflow.coil}
@Composable
@NonRestartableComposable
private fun DsIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DsIconModel.ImageVector
) {
    Icon(
        modifier = modifier.size(size),
        contentDescription = null,
        imageVector = model.value,
        tint = tint
    )
}

@Composable
@NonRestartableComposable
private fun DsIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = Dp.Unspecified,
    model: DsIconModel.DrawableResource
) {
    Icon(
        modifier = modifier.size(size),
        painter = painterResource(model.value),
        contentDescription = null,
        tint = tint
    )
}

@Composable
@NonRestartableComposable
private fun DsIcon(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    model: DsIconModel.Color
) {
    Box(
        modifier = modifier
            .size(size)
            .background(model.value)
    )
}