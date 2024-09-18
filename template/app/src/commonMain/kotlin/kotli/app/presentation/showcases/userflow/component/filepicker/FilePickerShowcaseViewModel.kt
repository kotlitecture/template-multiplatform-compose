package kotli.app.presentation.showcases.userflow.component.filepicker

import shared.design.component.AppFilePickerFile
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class FilePickerShowcaseViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    val filesState = DataState<List<AppFilePickerFile>>()

    fun onBack() {
        navigationStore.onBack()
    }

    fun onSelectFiles(files: List<AppFilePickerFile>) {
        filesState.set(files)
    }

}
