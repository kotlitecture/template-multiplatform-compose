package kotli.app.feature.showcases.userflow.component.markdown

import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class MarkdownShowcaseViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

}
