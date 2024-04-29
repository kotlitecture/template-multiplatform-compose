package core.ui.state

import androidx.compose.runtime.Immutable

/**
 * Represents the state of data specific to a particular domain or user flow.
 * This state can be shared between the Repository, ViewModel, and View layers.
 *
 * The state includes a [StoreObject] that holds the [DataState].
 */
@Immutable
abstract class StoreState {

    /** Store object to hold the [DataState]. */
    val dataStateStore by lazy { StoreObject<DataState>() }

    /**
     * Sets the data state to 'loaded' for the specified identifier.
     *
     * @param id The identifier associated with the loaded state.
     */
    fun loaded(id: String) = dataStateStore.set(DataState.Loaded(id))

    /**
     * Sets the data state to 'loading' for the specified identifier.
     *
     * @param id The identifier associated with the loading state.
     */
    fun loading(id: String) = dataStateStore.set(DataState.Loading(id))

    /**
     * Sets the data state to 'error' with the specified exception for the specified identifier.
     *
     * @param id The identifier associated with the error state.
     * @param e The exception causing the error state.
     */
    fun error(id: String, e: Exception) = dataStateStore.set(DataState.Error(id, e))

}