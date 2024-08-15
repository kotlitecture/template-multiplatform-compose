package kotli.app.presentation.showcases.userflow.component.image.coil

import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class CoilShowcaseViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

}
