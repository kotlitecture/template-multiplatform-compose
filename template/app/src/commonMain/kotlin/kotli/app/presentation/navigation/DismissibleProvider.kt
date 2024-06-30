package kotli.app.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel
import shared.design.container.AppDismissibleNavigation

/**
 * Composable function to display a dismissible left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun DismissibleProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionState.asStateValueNotNull()) {
        content()
        return
    }
    AppDismissibleNavigation(
        content = content,
        itemsState = viewModel.pagesState,
        visibilityState = viewModel.visibilityState,
        selectionState = viewModel.selectedPageState,
    )
}