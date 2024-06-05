package shared.presentation.size

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import shared.presentation.size.ViewSize.Unknown

/** Local composition used to access the current [ViewSize]. */
val LocalViewSize = compositionLocalOf { Unknown }

/**
 * Provides the size of its containing view to its children.
 *
 * @param modifier Modifier to be applied to the view size provider.
 * @param content Composable lambda to be executed with the view size as a parameter.
 */
@Composable
fun ViewSizeProvider(
    modifier: Modifier = Modifier.fillMaxSize(),
    content: @Composable BoxScope.(size: ViewSize) -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        val size = ViewSize.of(minWidth)
        if (size != Unknown) {
            CompositionLocalProvider(LocalViewSize provides size) {
                content(size)
            }
        }
    }
}

/**
 * https://m3.material.io/foundations/layout/applying-layout/window-size-classes
 */
enum class ViewSize {
    Unknown,
    Compact,
    Medium,
    Expanded,
    Large,
    ExtraLarge
    ;

    companion object {
        /** Returns the current [ViewSize] in the composition. */
        val current: ViewSize
            @Composable
            @ReadOnlyComposable
            get() = LocalViewSize.current

        @Stable
        fun of(width: Dp): ViewSize {
            return when {
                width < 600.dp -> Compact
                width < 840.dp -> Medium
                width < 1200.dp -> Expanded
                width < 1600.dp -> Large
                else -> ExtraLarge
            }
        }
    }
}
