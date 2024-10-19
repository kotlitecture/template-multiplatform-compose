package kotli.app.feature.navigation.b.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.design.component.AppText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BScreen() {
    val viewModel: BViewModel = provideViewModel()
    val state = viewModel.state

    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = state.title
        )
    }
}