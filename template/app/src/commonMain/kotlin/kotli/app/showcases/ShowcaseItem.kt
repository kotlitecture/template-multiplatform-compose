package kotli.app.showcases

import shared.presentation.navigation.NavigationDestination

/**
 * Represents a showcase item.
 *
 * This interface extends [Showcase] and provides additional functionality for handling clicks
 * and obtaining navigation destinations.
 */
interface ShowcaseItem : Showcase {

    /**
     * Handles the click event associated with this showcase item.
     *
     * @param viewModel The view model associated with showcases.
     */
    fun onClick(viewModel: ShowcasesViewModel)

    /**
     * Retrieves a list of navigation destinations associated with this showcase item.
     * By default, it returns an empty list.
     *
     * @return A list of navigation destinations.
     */
    fun dependsOn(): List<NavigationDestination<*>> = emptyList()

}