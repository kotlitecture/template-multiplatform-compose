package kotli.app.feature.showcases.presentation.userflow.loader.advanced

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.common.presentation.loader.LoaderDialog
import kotli.app.feature.showcases.presentation.ShowcaseHintBlock
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun AdvancedLoaderScreen(onBack: () -> Unit) {
    val viewModel: AdvancedLoaderViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn(
        title = AdvancedLoaderRoute.screen.label,
        onBack = onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the advanced usage of the LoaderDialog.
                    
                    In this example, the loader is used to catch any errors and show them to the user.
                """.trimIndent()
            )
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onShow,
                text = "Execute action with loader"
            )
        }
    )

    LoaderDialog(state.loaderState)
}