package kotli.app.common.presentation.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.ui.component.AppCard
import shared.presentation.ui.component.AppCircularProgressIndicator
import shared.presentation.ui.component.AppDialog
import shared.presentation.ui.component.AppErrorDialog
import shared.presentation.viewmodel.provideViewModel

@Composable
fun LoaderDialog(isLoading: () -> Boolean) {
    val viewModel: LoaderViewModel = provideViewModel()
    LaunchedEffect(isLoading) { viewModel.onBind(isLoading) }
    LoaderBlock(viewModel.state, viewModel::onClose)
}

@Composable
fun LoaderDialog(state: LoaderState) {
    LoaderBlock(state, state::cancel)
}

@Composable
private fun LoaderBlock(state: LoaderState, onClose: () -> Unit) {
    when {
        state.loading -> {
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

        state.error != null -> state.error?.let { error ->
            AppErrorDialog(
                title = state.id.orEmpty(),
                onClose = onClose,
                th = error
            )
        }
    }
}