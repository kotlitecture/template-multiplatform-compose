package kotli.app.presentation.navigation

import shared.presentation.navigation.NavigationDestination
import shared.presentation.store.DataState
import shared.presentation.store.Store

/**
 * Represents the store of the navigation bar.
 */
data class NavigationBarStore(
    val pages: List<NavigationBarPage>,
    val allowedDestinations: Set<NavigationDestination<*>> = emptySet(),
    val restrictedDestinations: Set<NavigationDestination<*>> = emptySet(),
) : Store() {

    /** Store navigation visibility state. */
    val visibilityState: DataState<Boolean> = DataState()

    /** State of the available pages. */
    val pagesState: DataState<List<NavigationBarPage>> = DataState(pages)

    /** State of the active page. */
    val selectedPageState: DataState<NavigationBarPage> = DataState()

}