package kotli.app.feature.a.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.design.component.AppText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun AScreen() {
    val viewModel: AViewModel = provideViewModel()
    val state = viewModel.state

    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = state.title
        )
    }
}