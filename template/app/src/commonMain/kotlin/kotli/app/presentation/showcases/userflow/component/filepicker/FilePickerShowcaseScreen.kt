package kotli.app.presentation.showcases.userflow.component.filepicker

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
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.design.component.AppCard
import shared.design.component.AppElevatedButton
import shared.design.component.AppFilePickerFile
import shared.design.component.AppSpacer16
import shared.design.component.AppText
import shared.design.component.getFileLauncher
import shared.design.container.AppFixedTopBarLazyColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun FilePickerShowcaseScreen() {
    val viewModel: FilePickerShowcaseViewModel = provideViewModel()
    val files = viewModel.filesState.asStateValue() ?: emptyList()
    AppFixedTopBarLazyColumn(
        title = FilePickerShowcase.label,
        onBack = viewModel::onBack,
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

            files.forEach { file ->
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
                    text = file.path,
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