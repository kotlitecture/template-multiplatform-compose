package app.ui.screen.template_no_args

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.appViewModel

@Composable
fun TemplateNoArgsScreen() {
    val viewModel = appViewModel(TemplateNoArgsViewModel::class)
    Column(Modifier
        .fillMaxSize()
        .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = viewModel::class.simpleName.orEmpty()
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = viewModel::onNext,
            content = {
                Text(text = "next")
            }
        )
    }
}