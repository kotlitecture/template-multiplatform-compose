package kotli.app.showcases.feature.loader.data

import kotli.app.AppState
import kotlinx.coroutines.delay
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState

class DataLoaderShowcaseViewModel(
    private val navigationState: NavigationState,
    private val appState: AppState
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
