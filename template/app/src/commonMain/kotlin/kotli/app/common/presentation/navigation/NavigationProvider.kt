package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable

@Composable
fun NavigationProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    content()
}