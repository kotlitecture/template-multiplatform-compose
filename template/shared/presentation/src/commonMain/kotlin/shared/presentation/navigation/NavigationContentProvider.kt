package shared.presentation.navigation

import androidx.compose.runtime.Composable

/**
 * Functional interface for providing navigation content.
 *
 * This interface is used to define a composable function that provides navigation content based on the given data.
 *
 * @param <D> The type of the data to be provided.
 */
fun interface NavigationContentProvider<D> {

    /**
     * Provides the navigation content based on the given data.
     *
     * This composable function uses the provided data to display relevant navigation content.
     *
     * @param data The data used to provide the navigation content. It can be nullable.
     */
    @Composable
    operator fun invoke(data: D?)

}