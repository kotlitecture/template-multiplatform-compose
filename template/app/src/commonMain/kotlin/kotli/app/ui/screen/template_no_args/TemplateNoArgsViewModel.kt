package kotli.app.ui.screen.template_no_args

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class TemplateNoArgsViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

}
