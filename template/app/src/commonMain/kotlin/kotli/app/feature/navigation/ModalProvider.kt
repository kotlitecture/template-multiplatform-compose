package kotli.app.feature.navigation

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel
import shared.design.container.AppModalNavigation

/**
 * Composable function to display a modal left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun ModalProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionState.asStateValueNotNull()) {
        content()
        return
    }
    AppModalNavigation(
        content = content,
        itemsState = viewModel.pagesState,
        visibilityState = viewModel.visibilityState,
        selectionState = viewModel.selectedPageState
    )
}