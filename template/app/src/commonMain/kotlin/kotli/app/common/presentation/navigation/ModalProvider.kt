package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.AppModalNavigation

@Composable
fun ModalProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    AppModalNavigation(
        state = state,
        content = content
    )
}