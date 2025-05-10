package kotli.app.showcases.presentation.userflow.common.component.filepicker

import androidx.compose.runtime.Stable
import shared.presentation.ui.component.DsFilePickerFile

@Stable
interface FilePickerState {

    val files: List<DsFilePickerFile>

}