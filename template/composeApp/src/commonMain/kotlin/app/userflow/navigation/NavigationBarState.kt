package app.userflow.navigation

import shared.core.navigation.NavigationDestination
import shared.core.state.StoreObject
import shared.core.state.StoreState

/**
 * Represents the state of the navigation bar.
 *
 * @param pages The list of available pages in the navigation bar.
 */
data class NavigationBarState(
    val pages: List<NavigationBarPage>,
    val allowedDestinations: Set<NavigationDestination<*>> = emptySet(),
    val restrictedDestinations: Set<NavigationDestination<*>> = emptySet(),
) : StoreState() {

    /** Store navigation visibility state. */
    val visibilityStore: StoreObject<Boolean> = StoreObject(false)

    /** Store object for the available pages. */
    val pagesStore: StoreObject<List<NavigationBarPage>> = StoreObject(pages)

    /** Store object for the active page. */
    val selectedPageStore: StoreObject<NavigationBarPage> = StoreObject()

}