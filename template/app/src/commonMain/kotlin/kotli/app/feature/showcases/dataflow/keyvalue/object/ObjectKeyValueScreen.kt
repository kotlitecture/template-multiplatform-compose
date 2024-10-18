package kotli.app.feature.showcases.dataflow.keyvalue.`object`

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.feature.showcases.ShowcaseHintBlock
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ObjectKeyValueScreen() {
    val viewModel: ObjectKeyValueViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = ObjectKeyValueShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the usage of [KeyValueSource] with objects.

                    Any changes you make in the input fields will be stored. When you reopen the app, the input field will be pre-filled with the last data.

                    Additionally, the date of the last save will be displayed.
                """.trimIndent()
            )
            InputBlock(viewModel.textState, viewModel.supportTextState)
        }
    )
}

@Composable
private fun InputBlock(state: MutableState<String>, supportState: MutableState<String>) {
    AppTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        valueState = state,
        placeholder = "Input your text",
        supportingText = supportState.value
    )
}