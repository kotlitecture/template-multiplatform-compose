package app.showcases.userflow.loader.data

import app.AppState
import kotlinx.coroutines.delay
import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

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
