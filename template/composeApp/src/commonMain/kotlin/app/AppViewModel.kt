package app

import core.ui.BaseViewModel
import core.ui.navigation.NavigationState

class AppViewModel(
    private val navigationRouter: AppNavigationRouter,
    val navigationState: NavigationState
) : BaseViewModel() {

    override fun doBind() {
        launchAsync("doBind") {
            val startDestination = navigationRouter.getStartDestination()
            navigationState.setStartDestination(startDestination)
        }
    }

}