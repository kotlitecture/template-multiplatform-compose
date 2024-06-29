package kotli.app.ui.screen.template

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class TemplateViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

}
