package app.ui.navigation.adaptive

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize

/**
 * Composable function to display an adaptive navigation.
 *
 * @param content The content to display.
 */
@Composable
fun AdaptiveNavigation(content: @Composable () -> Unit) {
    val sizeState = remember { mutableStateOf(IntSize.Zero) }
    Box(modifier = Modifier
        .fillMaxSize()
        .onSizeChanged {
            sizeState.value = it
        }
    ) {
        println(sizeState.value)
        content()
    }
}