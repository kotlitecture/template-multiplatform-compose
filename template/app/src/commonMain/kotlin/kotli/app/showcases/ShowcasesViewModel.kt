package kotli.app.showcases

import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

/**
 * ViewModel for the showcases screen.
 * It manages the state and actions related to showcases.
 */
class ShowcasesViewModel(
    val navigationState: NavigationState
) : BaseViewModel() {

    /**
     * Store object for managing the visibility of hints.
     */
    val hintStore = StoreObject(false)

    /**
     * Store object for managing the list of showcases.
     */
    val showcasesStore = StoreObject(Showcases.all)

    /**
     * Sets the hint visibility to true.
     */
    fun onShowHint() {
        hintStore.set(true)
    }

}
