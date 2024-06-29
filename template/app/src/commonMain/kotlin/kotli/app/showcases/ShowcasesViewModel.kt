package kotli.app.showcases

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

/**
 * ViewModel for the showcases screen.
 * It manages the state and actions related to showcases.
 */
class ShowcasesViewModel(
    val navigationStore: NavigationStore
) : BaseViewModel() {

    /**
     * Store object for managing the visibility of hints.
     */
    val hintState = DataState(false)

    /**
     * Store object for managing the list of showcases.
     */
    val showcasesState = DataState(Showcases.all)

    /**
     * Sets the hint visibility to true.
     */
    fun onShowHint() {
        hintState.set(true)
    }

}
