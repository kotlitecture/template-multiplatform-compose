package app.ui.screen.template_no_args

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.appViewModel

@Composable
fun TemplateScreen() {
    val viewModel = appViewModel(TemplateNoArgsViewModel::class)
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = viewModel::class.simpleName.orEmpty()
        )
    }
}