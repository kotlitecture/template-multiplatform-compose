package kotli.app.feature.a.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotli.app.feature.a.domain.ARoute
import shared.design.component.AppText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun AScreen(route: ARoute) {
    val viewModel: AViewModel = provideViewModel()

    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = "A"
        )
    }
}