package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.AppRailNavigation

@Composable
fun RailProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    AppRailNavigation(
        state = state,
        content = content
    )
}