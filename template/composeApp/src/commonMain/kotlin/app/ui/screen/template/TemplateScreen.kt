package app.ui.screen.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.appViewModel

@Composable
fun TemplateScreen(data: TemplateDestination.Data) {
    val viewModel = appViewModel(TemplateViewModel::class)
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = data.title
        )
    }
}