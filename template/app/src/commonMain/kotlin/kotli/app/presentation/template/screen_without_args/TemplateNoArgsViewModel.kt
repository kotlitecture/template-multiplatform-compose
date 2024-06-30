package kotli.app.presentation.template.screen_without_args

import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class TemplateNoArgsViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() = navigationStore::onBack

}
