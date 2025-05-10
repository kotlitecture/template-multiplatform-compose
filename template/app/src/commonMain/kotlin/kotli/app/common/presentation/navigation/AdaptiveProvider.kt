package kotli.app.common.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import shared.presentation.ui.container.DsAdaptiveLayout
import shared.presentation.ui.container.LayoutSize

@Composable
@NonRestartableComposable
fun AdaptiveProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsAdaptiveLayout { size ->
        when {
            size <= LayoutSize.Compact -> Bottom(state, content)
            size < LayoutSize.Large -> Rail(state, content)
            else -> Permanent(state, content)
        }
    }
}

@Composable
@NonRestartableComposable
private fun Bottom(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f)) { content() }
        BottomProvider(
            state = state,
            modifier = Modifier.wrapContentHeight()
        )
    }
}

@Composable
@NonRestartableComposable
private fun Rail(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    RailProvider(state, content)
}

@Composable
@NonRestartableComposable
private fun Permanent(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    PermanentProvider(state, content)
}