package kotli.app.feature.navigation

import shared.presentation.navigation.NavigationDestination
import shared.presentation.store.DataState
import shared.presentation.store.Store

/**
 * Represents the state of the navigation bar.
 *
 * @param pages The list of available pages in the navigation bar.
 */
data class NavigationBarState(
    val pages: List<NavigationBarPage>,
    val allowedDestinations: Set<NavigationDestination<*>> = emptySet(),
    val restrictedDestinations: Set<NavigationDestination<*>> = emptySet(),
) : Store() {

    /** Store navigation visibility state. */
    val visibilityStore: DataState<Boolean> = DataState()

    /** Store object for the available pages. */
    val pagesStore: DataState<List<NavigationBarPage>> = DataState(pages)

    /** Store object for the active page. */
    val selectedPageStore: DataState<NavigationBarPage> = DataState()

}