package app.showcases.navigation.no_args.to

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.appViewModel
import app.showcases.ShowcaseHintBlock
import app.showcases.navigation.no_args.NoArgsNavigationShowcase
import shared.design.container.FixedTopBarColumnLayout

@Composable
fun NoArgsNavigationToScreen() {
    val viewModel = appViewModel(NoArgsNavigationToViewModel::class)
    FixedTopBarColumnLayout(
        title = NoArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This is the final destination [NoArgsNavigationToDestination].
                """.trimIndent()
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