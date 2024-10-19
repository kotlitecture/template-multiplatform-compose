package kotli.app.feature.showcases.presentation.userflow.component.filepicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.design.component.AppFilePickerFile
import shared.presentation.viewmodel.BaseViewModel

class FilePickerViewModel : BaseViewModel() {

    private val _state = FilePickerMutableState()
    val state: FilePickerState = _state

    fun onSelectFiles(files: List<AppFilePickerFile>) {
        _state.files = files
    }

    private class FilePickerMutableState : FilePickerState {
        override var files: List<AppFilePickerFile> by mutableStateOf(emptyList())
    }

}
