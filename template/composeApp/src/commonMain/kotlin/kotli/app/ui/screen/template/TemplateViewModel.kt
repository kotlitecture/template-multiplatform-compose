package kotli.app.ui.screen.template

import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class TemplateViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
