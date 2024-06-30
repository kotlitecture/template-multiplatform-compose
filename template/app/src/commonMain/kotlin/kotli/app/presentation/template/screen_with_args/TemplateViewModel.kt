package kotli.app.presentation.template.screen_with_args

import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class TemplateViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() = navigationStore.onBack()

}
