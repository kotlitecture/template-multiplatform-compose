package kotli.app.showcases.feature.loader.data

import kotli.app.AppStore
import kotlinx.coroutines.delay
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class DataLoaderShowcaseViewModel(
    private val navigationStore: NavigationStore,
    private val appStore: AppStore
) : BaseViewModel() {

    fun onBack() {
        navigationStore.onBack()
    }

    fun onPerformAsyncAction() {
        launchAsync("onPerformAsyncAction", appStore) {
            delay(3000L)
        }
    }

}
