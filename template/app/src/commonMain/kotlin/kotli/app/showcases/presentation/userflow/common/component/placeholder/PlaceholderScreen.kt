package kotli.app.showcases.presentation.userflow.common.component.placeholder

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.showcases.presentation.ShowcaseHintBlock
import shared.presentation.ui.component.AppElevatedButton
import shared.presentation.ui.component.AppTextField
import shared.presentation.ui.component.withPlaceholder
import shared.presentation.ui.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PlaceholderScreen(onBack: () -> Unit) {
    val viewModel: PlaceholderViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn(
        title = PlaceholderRoute.screen.label,
        onBack = onBack,
        content = {
            val loading = state.loading

            ShowcaseHintBlock(
                modifier = Modifier
                    .withPlaceholder(loading, cornerRadius = 8.dp),
                text = """
                    This showcase demonstrates the usage of app placeholders.

                    Placeholders can be applied to any composable via Modifier to simulate a loading state.
                """.trimIndent()
            )

            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .withPlaceholder(loading, cornerRadius = 16.dp),
                onClick = viewModel::onShow,
                text = "Show placeholders"
            )

            AppTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .withPlaceholder(loading, cornerRadius = 8.dp),
                valueState = remember { mutableStateOf("") },
                placeholder = "Text"
            )
        }
    )
}