package kotli.app.presentation.app

import shared.design.component.AppSnackbarStore
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

/**
 * ViewModel for the main screen of the application.
 */
class AppViewModel(
    private val navigationRouter: AppNavigationRouter,
    val navigationStore: NavigationStore,
    val snackbarStore: AppSnackbarStore,
    val appStore: AppStore
) : BaseViewModel() {

    override fun doBind() {
        launchAsync("doBind") {
            val startDestination = navigationRouter.getStartDestination()
            navigationStore.setStartDestination(startDestination)
        }
    }

}