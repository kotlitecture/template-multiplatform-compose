package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.AppDismissibleNavigation

@Composable
fun DismissibleProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    AppDismissibleNavigation(
        state = state,
        content = content
    )
}