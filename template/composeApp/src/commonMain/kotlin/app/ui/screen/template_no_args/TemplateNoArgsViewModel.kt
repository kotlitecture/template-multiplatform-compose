package app.ui.screen.template_no_args

import app.ui.screen.template.TemplateDestination
import core.ui.BaseViewModel
import core.ui.navigation.NavigationState

class TemplateNoArgsViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onNext() {
        navigationState.onNext(
            TemplateDestination,
            TemplateDestination.Data("ASASAS")
        )
    }

}
