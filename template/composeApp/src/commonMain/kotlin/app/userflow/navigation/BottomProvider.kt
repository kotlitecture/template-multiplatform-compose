package app.userflow.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.userflow.navigation.NavigationBarViewModel
import shared.core.provideViewModel
import shared.design.container.AppBottomNavigation

/**
 * Composable function responsible for rendering the bottom navigation bar.
 */
@Composable
fun BottomProvider(modifier: Modifier = Modifier) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        return
    }
    AppBottomNavigation(
        modifier = modifier,
        itemsStore = viewModel.pagesStore,
        visibilityStore = viewModel.visibilityStore,
        selectionStore = viewModel.selectedPageStore
    )
}