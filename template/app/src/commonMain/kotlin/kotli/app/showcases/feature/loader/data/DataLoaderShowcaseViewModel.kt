package kotli.app.showcases.feature.loader.data

import kotli.app.AppStore
import kotlinx.coroutines.delay
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class DataLoaderShowcaseViewModel(
    private val navigationState: NavigationStore,
    private val appState: AppStore
) : BaseViewModel() {

    fun onBack() {
        navigationState.onBack()
    }

    fun onPerformAsyncAction() {
        launchAsync("onPerformAsyncAction", appState) {
            delay(3000L)
        }
    }

}
