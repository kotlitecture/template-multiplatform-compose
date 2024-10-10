package kotli.app.common.presentation.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.design.component.AppCard
import shared.design.component.AppCircularProgressIndicator
import shared.design.component.AppDialog
import shared.presentation.store.Store
import shared.presentation.viewmodel.provideViewModel

/**
 * Composable function for providing a data loading indicator.
 * This function displays a loading dialog when the provided state indicates that data is being loaded.
 * The dialog contains a circular progress indicator.
 *
 * @param isLoading The loading state of the dialog.
 */
@Composable
fun LoaderDialog(isLoading: () -> Boolean) {
    val viewModel: LoaderViewModel = provideViewModel()
    LaunchedEffect(isLoading) { viewModel.onBind(isLoading) }
    LoaderBlock(viewModel.state)
}

@Composable
private fun LoaderBlock(state: LoaderState) {
    if (!state.loading) return

    AppDialog(onDismissRequest = {}) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AppCard {
                AppCircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}