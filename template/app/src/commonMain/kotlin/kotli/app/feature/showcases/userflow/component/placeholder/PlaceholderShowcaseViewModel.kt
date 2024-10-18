package kotli.app.feature.showcases.userflow.component.placeholder

import kotlinx.coroutines.delay
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class PlaceholderShowcaseViewModel(
    private val navigationStore: NavigationStore,
) : BaseViewModel() {

    val loadingState = DataState(false)

    fun onBack() {
        navigationStore.onBack()
    }

    fun onShow() {
        async("onShow") {
            loadingState.set(true)
            delay(3000L)
            loadingState.set(false)
        }
    }

}
