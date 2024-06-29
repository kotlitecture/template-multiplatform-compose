package kotli.app.ui.screen.template

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class TemplateViewModel(
    private val navigationState: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
