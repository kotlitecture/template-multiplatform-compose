package app.showcases.navigation.args.to

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.appViewModel
import app.showcases.ShowcaseHintBlock
import app.showcases.navigation.args.ArgsNavigationShowcase
import shared.design.container.FixedTopBarColumnLayout

@Composable
fun ArgsNavigationToScreen(data: ArgsNavigationToDestination.Data) {
    val viewModel = appViewModel(ArgsNavigationToViewModel::class)
    FixedTopBarColumnLayout(
        title = ArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = "Hello, ${data.userName}!"
            )
            ElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onBack,
                content = { Text(text = "Go back") }
            )
        }
    )
}