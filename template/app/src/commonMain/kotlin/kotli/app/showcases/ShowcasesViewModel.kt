package kotli.app.showcases

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.store.DataState

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
    val hintStore = DataState(false)

    /**
     * Store object for managing the list of showcases.
     */
    val showcasesStore = DataState(Showcases.all)

    /**
     * Sets the hint visibility to true.
     */
    fun onShowHint() {
        hintStore.set(true)
    }

}
