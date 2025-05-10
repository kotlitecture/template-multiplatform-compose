package shared.presentation.ui.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color as UiColor
import androidx.compose.ui.graphics.painter.Painter as UiPainter
import androidx.compose.ui.graphics.vector.ImageVector as UiImageVector
import org.jetbrains.compose.resources.DrawableResource as UiDrawableResource

@Immutable
sealed class DsIconModel {

    data class DrawableResource(val value: UiDrawableResource) : DsIconModel()
    data class Painter(val value: @Composable () -> UiPainter) : DsIconModel()
    data class ImageVector(val value: UiImageVector) : DsIconModel()
    data class Color(val value: UiColor) : DsIconModel()
    data class Url(val value: String?) : DsIconModel()
}


