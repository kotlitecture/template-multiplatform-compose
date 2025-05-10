package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.DsRailNavigation

@Composable
fun RailProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsRailNavigation(
        state = state,
        content = content
    )
}