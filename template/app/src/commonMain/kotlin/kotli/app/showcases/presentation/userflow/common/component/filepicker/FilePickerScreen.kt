package kotli.app.showcases.presentation.userflow.common.component.filepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotli.app.showcases.presentation.ShowcaseHintBlock
import shared.presentation.ui.component.AppCard
import shared.presentation.ui.component.AppElevatedButton
import shared.presentation.ui.component.AppFilePickerFile
import shared.presentation.ui.component.AppSpacer16
import shared.presentation.ui.component.AppText
import shared.presentation.ui.component.getFileLauncher
import shared.presentation.ui.container.AppFixedTopBarLazyColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun FilePickerScreen(onBack: () -> Unit) {
    val viewModel: FilePickerViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarLazyColumn(
        title = FilePickerRoute.screen.label,
        onBack = onBack,
        content = {
            item {
                ShowcaseHintBlock(
                    text = """
                    This showcase demonstrates the usage of app file picker API.
                """.trimIndent()
                )
            }

            item {
                val filePicker = getFileLauncher(onResult = viewModel::onSelectFiles)

                AppElevatedButton(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    onClick = filePicker::launch,
                    text = "Select files"
                )
            }

            state.files.forEach { file ->
                item { FileBlock(file) }
            }

            item { AppSpacer16() }
        }
    )
}

@Composable
private fun FileBlock(file: AppFilePickerFile) {
    AppCard(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                AppText(
                    text = file.name,
                    maxLines = 1,
                    fontSize = 16.sp,
                )
                AppText(
                    text = file.getSize().toString() + " bytes",
                    maxLines = 1,
                    fontSize = 12.sp
                )
            }

            Column(modifier = Modifier.wrapContentWidth()) {
                AppText(
                    text = "${file.getSize()?.let { it / 1024 } ?: '?'} Kb",
                    maxLines = 1,
                    fontSize = 14.sp,
                )
            }
        }
    }
}