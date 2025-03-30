package kotli.app.showcases.presentation.userflow.component.filepicker

import androidx.compose.runtime.Stable
import shared.presentation.ui.component.AppFilePickerFile

@Stable
interface FilePickerState {

    val files: List<AppFilePickerFile>

}