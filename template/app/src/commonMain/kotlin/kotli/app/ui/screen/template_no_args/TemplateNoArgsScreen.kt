package kotli.app.ui.screen.template_no_args

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppText

@Composable
fun TemplateNoArgsScreen() {
    val viewModel: TemplateNoArgsViewModel = provideViewModel()
    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = viewModel::class.simpleName.orEmpty()
        )
    }
}