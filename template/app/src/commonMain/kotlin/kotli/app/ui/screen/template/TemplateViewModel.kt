package kotli.app.ui.screen.template

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationState

class TemplateViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
