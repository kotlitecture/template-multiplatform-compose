package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.DsModalNavigation

@Composable
fun ModalProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsModalNavigation(
        state = state,
        content = content
    )
}