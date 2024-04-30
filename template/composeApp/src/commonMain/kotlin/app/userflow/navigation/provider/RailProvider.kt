package app.userflow.navigation.provider

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.userflow.navigation.NavigationBarViewModel
import shared.core.provideViewModel
import shared.design.container.AppRailNavigation

/**
 * Composable function to display rail navigation.
 *
 * @param content The content to display.
 */
@Composable
fun RailProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    AppRailNavigation(
        content = content,
        itemsStore = viewModel.pagesStore,
        visibilityStore = viewModel.visibilityStore,
        selectionStore = viewModel.selectedPageStore,
    )
}