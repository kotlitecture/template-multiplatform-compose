package app.userflow.navigation

import androidx.compose.runtime.Composable
import app.userflow.navigation.NavigationBarViewModel
import shared.core.provideViewModel
import shared.design.container.AppModalNavigation

/**
 * Composable function to display a modal left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun ModalProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    AppModalNavigation(
        content = content,
        itemsStore = viewModel.pagesStore,
        visibilityStore = viewModel.visibilityStore,
        selectionStore = viewModel.selectedPageStore
    )
}