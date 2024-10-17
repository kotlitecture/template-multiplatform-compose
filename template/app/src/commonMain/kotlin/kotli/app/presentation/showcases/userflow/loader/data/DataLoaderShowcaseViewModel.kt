package kotli.app.presentation.showcases.userflow.loader.data

import kotlinx.coroutines.delay
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class DataLoaderShowcaseViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

    fun onPerformAsyncAction() {
        async("onPerformAsyncAction") {
            delay(3000L)
        }
    }

}
