package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.DsDismissibleNavigation

@Composable
fun DismissibleProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsDismissibleNavigation(
        state = state,
        content = content
    )
}