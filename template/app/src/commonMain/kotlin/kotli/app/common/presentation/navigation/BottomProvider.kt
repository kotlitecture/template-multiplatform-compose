package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.presentation.ui.container.DsBottomNavigation

@Composable
fun BottomProvider(
    state: NavigationState,
    modifier: Modifier = Modifier,
) {
    DsBottomNavigation(
        state = state,
        modifier = modifier,
    )
}