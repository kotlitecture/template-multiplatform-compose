package shared.presentation.store

import androidx.compose.runtime.Immutable

/**
 * The concept is similar to https://pinia.vuejs.org and is more flexible to use in comparison to well-known 'UI State' pattern.
 *
 * Represents the store of a particular domain or user flow.
 *
 * This store can be shared between the ViewModel and View layers.
 */
@Immutable
abstract class Store {

    /** State object to hold the [DataLoading]. */
    val loadingState: DataState<DataLoading> by lazy(::DataState)

    /**
     * Sets the loading state to 'loaded' for the specified identifier.
     *
     * @param id The identifier associated with the loaded state.
     */
    fun loaded(id: String) = loadingState.set(DataLoading.Loaded(id))

    /**
     * Sets the loading state to 'loading' for the specified identifier.
     *
     * @param id The identifier associated with the loading state.
     */
    fun loading(id: String) = loadingState.set(DataLoading.InProgress(id))

    /**
     * Sets the loading state to 'error' with the specified exception for the specified identifier.
     *
     * @param id The identifier associated with the error state.
     * @param e The exception causing the error state.
     */
    fun error(id: String, e: Exception) = loadingState.set(DataLoading.Error(id, e))

}