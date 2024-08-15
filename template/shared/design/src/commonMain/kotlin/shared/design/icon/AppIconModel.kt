package shared.design.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

@Immutable
sealed class AppIconModel

data class ColorModel(val value: Color) : AppIconModel()

data class UrlModel(val value: String?) : AppIconModel()

data class ImageVectorModel(val value: ImageVector) : AppIconModel()

data class DrawableResourceModel(val value: DrawableResource) : AppIconModel()

data class PainterModel(val value: @Composable () -> Painter) : AppIconModel()



