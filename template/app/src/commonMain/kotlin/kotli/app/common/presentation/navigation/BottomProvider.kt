package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.design.container.AppBottomNavigation

@Composable
fun BottomProvider(
    state: NavigationState,
    modifier: Modifier = Modifier,
) {
    AppBottomNavigation(
        state = state,
        modifier = modifier,
    )
}