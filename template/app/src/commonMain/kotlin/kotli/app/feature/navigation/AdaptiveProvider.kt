package kotli.app.feature.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.presentation.size.ViewSize
import shared.presentation.size.ViewSizeProvider

/**
 * Composable function to display an adaptive navigation.
 *
 * @param content The content to display.
 */
@Composable
fun AdaptiveProvider(content: @Composable () -> Unit) {
    ViewSizeProvider { size ->
        when {
            size <= ViewSize.Compact -> Bottom(content)
            size <= ViewSize.Large -> Rail(content)
            else -> Permanent(content)
        }
    }
}

@Composable
private fun Bottom(content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f)) { content() }
        BottomProvider(Modifier.wrapContentHeight())
    }
}

@Composable
private fun Rail(content: @Composable () -> Unit) {
    RailProvider(content)
}

@Composable
private fun Permanent(content: @Composable () -> Unit) {
    PermanentProvider(content)
}