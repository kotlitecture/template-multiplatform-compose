package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.design.container.AppPermanentNavigation

@Composable
fun PermanentProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    AppPermanentNavigation(
        state = state,
        content = content
    )
}