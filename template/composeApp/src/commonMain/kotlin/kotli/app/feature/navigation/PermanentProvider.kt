package kotli.app.feature.navigation

import androidx.compose.runtime.Composable
import shared.presentation.provideViewModel
import shared.design.container.AppPermanentNavigation

/**
 * Composable function to display permanent left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun PermanentProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    AppPermanentNavigation(
        content = content,
        itemsStore = viewModel.pagesStore,
        visibilityStore = viewModel.visibilityStore,
        selectionStore = viewModel.selectedPageStore,
    )
}