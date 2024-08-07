package shared.design.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

@Immutable
sealed class AppIconModel

data class ColorIcon(val value: Color) : AppIconModel()

data class UrlIcon(val value: String?) : AppIconModel()

data class ImageVectorIcon(val value: ImageVector) : AppIconModel()

data class DrawableResourceIcon(val value: DrawableResource) : AppIconModel()

data class PainterIcon(val value: @Composable () -> Painter) : AppIconModel()



