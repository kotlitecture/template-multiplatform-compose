package kotli.app.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.presentation.viewmodel.provideViewModel
import shared.design.container.AppBottomNavigation

/**
 * Composable function responsible for rendering the bottom navigation bar.
 */
@Composable
fun BottomProvider(modifier: Modifier = Modifier) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionState.asStateValueNotNull()) {
        return
    }
    AppBottomNavigation(
        modifier = modifier,
        itemsState = viewModel.pagesState,
        visibilityState = viewModel.visibilityState,
        selectionState = viewModel.selectedPageState
    )
}