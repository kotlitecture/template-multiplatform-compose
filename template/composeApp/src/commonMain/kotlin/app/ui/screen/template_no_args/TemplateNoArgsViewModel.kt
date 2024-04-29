package app.ui.screen.template_no_args

import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class TemplateNoArgsViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
