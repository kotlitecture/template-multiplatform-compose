package kotli.app.navigation.b.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.presentation.ui.component.DsText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BScreen() {
    val viewModel: BViewModel = provideViewModel()
    val state = viewModel.state

    Box(Modifier.fillMaxSize()) {
        DsText(
            modifier = Modifier.align(Alignment.Center),
            text = state.title
        )
    }
}