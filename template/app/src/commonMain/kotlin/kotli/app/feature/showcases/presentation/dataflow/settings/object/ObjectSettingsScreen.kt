package kotli.app.feature.showcases.presentation.dataflow.settings.`object`

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.feature.showcases.presentation.ShowcaseHintBlock
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ObjectSettingsScreen(onBack: () -> Unit) {
    val viewModel: ObjectSettingsViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarColumn(
        title = ObjectSettingsRoute.screen.label,
        onBack = onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the usage of [SettingsSource] with objects.

                    Any changes you make in the input fields will be stored. When you reopen the app, the input field will be pre-filled with the last data.

                    Additionally, the date of the last save will be displayed.
                """.trimIndent()
            )
            InputBlock(
                state = state,
                onTextChanged = viewModel::onTextChanged
            )
        }
    )
}

@Composable
private fun InputBlock(
    state: ObjectSettingsState,
    onTextChanged: (text: String) -> Unit
) {
    AppTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        getValue = state::text::get,
        onValueChange = onTextChanged,
        placeholder = "Input your text",
        supportingText = state.supportText
    )
}