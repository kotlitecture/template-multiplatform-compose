package kotli.app.showcases.userflow.loader.data

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.showcases.ShowcaseHintBlock
import shared.core.provideViewModel
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn

@Composable
fun DataLoaderShowcaseScreen() {
    val viewModel: DataLoaderShowcaseViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = DataLoaderShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the usage of the app data loader.

                    Whenever an operation needs to block the entire screen, simply pass an [AppState] instance into the `launchAsync` method of the [BaseViewModel]. The app screen will be covered with an overlay provided by [DataLoaderProvider].
                """.trimIndent()
            )
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onPerformAsyncAction,
                text = "Execute action with loader"
            )
        }
    )
}