package app.userflow.loader.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import shared.core.provideViewModel
import shared.core.state.StoreState
import shared.design.component.AppCircularProgressIndicator
import shared.design.component.AppDialog

/**
 * Composable function for providing a data loading indicator.
 * This function displays a loading dialog when the provided state indicates that data is being loaded.
 * The dialog contains a circular progress indicator.
 *
 * @param state The state object representing the current data loading state.
 */
@Composable
fun DataLoaderProvider(state: StoreState) {
    val viewModel: DataLoaderViewModel = provideViewModel()
    LaunchedEffect(state) { viewModel.onBind(state) }
    DataLoaderBlock(viewModel)
}

@Composable
private fun DataLoaderBlock(viewModel: DataLoaderViewModel) {
    val isLoading = viewModel.isLoadingStore.asStateValueNotNull()
    if (!isLoading) return
    AppDialog(onDismissRequest = {}) {
        AppCircularProgressIndicator()
    }
}