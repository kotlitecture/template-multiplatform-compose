package kotli.app.ui.screen.template_no_args

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationState

class TemplateNoArgsViewModel(
    private val navigationState: NavigationState
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

}
