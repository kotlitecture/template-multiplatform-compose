package kotli.app.feature.c.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotli.app.feature.c.domain.CRoute
import shared.design.component.AppText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun CScreen(route: CRoute) {
    val viewModel: CViewModel = provideViewModel()

    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = "C"
        )
    }
}