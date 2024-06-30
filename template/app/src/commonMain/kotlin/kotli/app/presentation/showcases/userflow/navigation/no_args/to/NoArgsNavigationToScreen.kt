package kotli.app.presentation.showcases.userflow.navigation.no_args.to

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import kotli.app.presentation.showcases.userflow.navigation.no_args.NoArgsNavigationShowcase
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn

@Composable
fun NoArgsNavigationToScreen() {
    val viewModel: NoArgsNavigationToViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = NoArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This is the final destination [NoArgsNavigationToDestination].
                """.trimIndent()
            )
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onBack,
                text = "Go back"
            )
        }
    )
}