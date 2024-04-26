package core.ui.misc.utils

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.ui.misc.utils.WindowSize.Unknown

/** Local composition used to access the current [WindowSize]. */
val LocalWindowSize = compositionLocalOf { Unknown }

@Composable
fun WindowSizeProvider(content: @Composable (size: WindowSize) -> Unit) {
    val sizeState = remember { mutableStateOf(Unknown) }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val size = WindowSize.of(minWidth)
        LaunchedEffect(minWidth) { sizeState.value = size }
    }
    val size = sizeState.value
    if (size == Unknown) return
    CompositionLocalProvider(LocalWindowSize provides size) {
        content(size)
    }
}

/**
 * https://m3.material.io/foundations/layout/applying-layout/window-size-classes
 */
enum class WindowSize {
    Unknown,
    Compact,
    Medium,
    Expanded,
    Large,
    ExtraLarge
    ;

    companion object {
        /** Returns the current [WindowSize] in the composition. */
        val current: WindowSize
            @Composable
            @ReadOnlyComposable
            get() = LocalWindowSize.current

        @Stable
        fun of(width: Dp): WindowSize {
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
