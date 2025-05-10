package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.DsPermanentNavigation

@Composable
fun PermanentProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsPermanentNavigation(
        state = state,
        content = content
    )
}