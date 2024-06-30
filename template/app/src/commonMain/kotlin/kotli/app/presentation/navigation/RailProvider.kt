package kotli.app.presentation.navigation

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel
import shared.design.container.AppRailNavigation

/**
 * Composable function to display rail navigation.
 *
 * @param content The content to display.
 */
@Composable
fun RailProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionState.asStateValueNotNull()) {
        content()
        return
    }
    AppRailNavigation(
        content = content,
        itemsState = viewModel.pagesState,
        visibilityState = viewModel.visibilityState,
        selectionState = viewModel.selectedPageState,
    )
}