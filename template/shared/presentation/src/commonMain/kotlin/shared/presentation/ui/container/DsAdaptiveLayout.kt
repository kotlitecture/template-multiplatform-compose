package shared.presentation.ui.container

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
import shared.presentation.ui.container.LayoutSize.Unknown

internal val LocalLayoutSize = compositionLocalOf { Unknown }

@Composable
fun DsAdaptiveLayout(
    modifier: Modifier = Modifier.fillMaxSize(),
    content: @Composable BoxScope.(size: LayoutSize) -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        val size = LayoutSize.of(minWidth)
        if (size != Unknown) {
            CompositionLocalProvider(LocalLayoutSize provides size) {
                content(size)
            }
        }
    }
}

/**
 * https://m3.material.io/foundations/layout/applying-layout/window-size-classes
 */
enum class LayoutSize {
    Unknown,
    Compact,
    Medium,
    Expanded,
    Large,
    ExtraLarge
    ;

    companion object {
        val current: LayoutSize
            @Composable
            @ReadOnlyComposable
            get() = LocalLayoutSize.current

        @Stable
        fun of(width: Dp): LayoutSize {
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
