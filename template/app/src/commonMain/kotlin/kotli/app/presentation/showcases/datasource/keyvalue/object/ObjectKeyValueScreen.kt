package kotli.app.presentation.showcases.datasource.keyvalue.`object`

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.presentation.viewmodel.provideViewModel
import shared.presentation.store.DataState
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn

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
private fun InputBlock(store: DataState<String>, supportStore: DataState<String>) {
    AppTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        valueState = store,
        placeholder = "Input your text",
        supportingText = supportStore.asStateValue()
    )
}