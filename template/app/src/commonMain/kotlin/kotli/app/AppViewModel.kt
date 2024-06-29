package kotli.app

import shared.design.component.AppSnackbarState
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

/**
 * ViewModel for the main screen of the application.
 */
class AppViewModel(
    private val navigationRouter: AppNavigationRouter,
    val navigationState: NavigationStore,
    val snackbarState: AppSnackbarState,
    val appState: AppStore
) : BaseViewModel() {

    override fun doBind() {
        launchAsync("doBind") {
            val startDestination = navigationRouter.getStartDestination()
            navigationState.setStartDestination(startDestination)
        }
    }

}