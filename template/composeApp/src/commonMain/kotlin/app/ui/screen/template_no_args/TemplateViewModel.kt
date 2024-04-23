package app.ui.screen.template_no_args

import core.ui.BaseViewModel
import core.ui.navigation.NavigationState

class TemplateViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
