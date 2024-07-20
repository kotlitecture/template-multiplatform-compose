package kotli.app.presentation.showcases.userflow.component.placeholder

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.design.component.AppElevatedButton
import shared.design.component.AppSpacer16
import shared.design.component.AppTextField
import shared.design.component.withPlaceholder
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.store.DataState
import shared.presentation.viewmodel.provideViewModel

@Composable
fun PlaceholderShowcaseScreen() {
    val viewModel: PlaceholderShowcaseViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = PlaceholderShowcase.label,
        onBack = viewModel::onBack,
        content = {
            val loading = viewModel.loadingState.asStateValueNotNull()

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
                valueState = remember { DataState("") },
                placeholder = "Text"
            )
        }
    )
}