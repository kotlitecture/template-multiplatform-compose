package app.userflow.navigation

import androidx.compose.runtime.Composable
import app.userflow.navigation.NavigationBarViewModel
import shared.core.provideViewModel
import shared.design.container.AppDismissibleNavigation

/**
 * Composable function to display a dismissible left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun DismissibleProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    AppDismissibleNavigation(
        content = content,
        itemsStore = viewModel.pagesStore,
        visibilityStore = viewModel.visibilityStore,
        selectionStore = viewModel.selectedPageStore,
    )
}