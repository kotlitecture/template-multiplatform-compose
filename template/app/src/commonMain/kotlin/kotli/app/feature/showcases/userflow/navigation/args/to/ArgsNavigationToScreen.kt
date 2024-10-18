package kotli.app.feature.showcases.userflow.navigation.args.to

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.feature.showcases.ShowcaseHintBlock
import kotli.app.feature.showcases.userflow.navigation.args.ArgsNavigationShowcase
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn

@Composable
fun ArgsNavigationToScreen(data: ArgsNavigationToDestination.Data) {
    val viewModel: ArgsNavigationToViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = ArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = "Hello, ${data.userName}!"
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