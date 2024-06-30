package kotli.app.presentation.template.screen_with_args

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.design.component.AppText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun TemplateScreen(data: TemplateDestination.Data) {
    val viewModel: TemplateViewModel = provideViewModel()

    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = data.title
        )
    }
}