package kotli.app.feature.navigation

import androidx.compose.runtime.Composable
import shared.presentation.viewmodel.provideViewModel
import shared.design.container.AppPermanentNavigation

/**
 * Composable function to display permanent left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun PermanentProvider(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
    if (viewModel.restrictionState.asStateValueNotNull()) {
        content()
        return
    }
    AppPermanentNavigation(
        content = content,
        itemsState = viewModel.pagesState,
        visibilityState = viewModel.visibilityState,
        selectionState = viewModel.selectedPageState,
    )
}