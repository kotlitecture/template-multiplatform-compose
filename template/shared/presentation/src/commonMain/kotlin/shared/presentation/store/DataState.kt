package shared.presentation.store

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.updateAndGet

/**
 * State object that holds a value of type [T].
 *
 * @param T the type of the value stored in the state.
 * @property value The initial value of the state.
 */
@Immutable
data class DataState<T>(private val value: T? = null) {

    private val valueChanges = MutableStateFlow(value)

    /**
     * Returns the state as a [MutableState] object.
     */
    @Stable
    @Composable
    fun asState(): State<T?> = valueChanges
        .collectAsState()

    /**
     * Returns the value of the store object as a [MutableState] object.
     */
    @Composable
    fun asStateValue(): T? = asState().value

    /**
     * Returns the store object as a non-nullable [MutableState] object.
     */
    @Stable
    @Composable
    fun asStateNotNull(): State<T> = valueChanges
        .mapNotNull { it }
        .collectAsState(getNotNull())

    /**
     * Returns the value of the store object as a non-nullable type [T].
     */
    @Composable
    fun asStateValueNotNull(): T = asStateNotNull()
        .value

    /**
     * Returns the store object as a flow of type [T].
     */
    @Stable
    fun asFlow(): Flow<T?> = valueChanges

    /**
     * Returns the store object as a flow of type [T].
     */
    @Stable
    fun asStateFlow(): StateFlow<T?> = valueChanges

    /**
     * Gets the non-nullable value of the store object.
     */
    fun getNotNull(): T = valueChanges.value!!

    /**
     * Gets the value of the store object.
     */
    fun get(): T? = valueChanges.value

    /**
     * Checks if the current value is null.
     * @return true if the current value is null, false otherwise.
     */
    fun isNull(): Boolean = valueChanges.value == null

    /**
     * Checks if the current value is not null.
     * @return true if the current value is not null, false otherwise.
     */
    fun isNotNull(): Boolean = !isNull()

    /**
     * Clears the value of the store object to the initial state.
     */
    fun clear() = set(value)

    /**
     * Sets the value of the store object.
     */
    fun set(value: T?) {
        update { value }
    }

    /**
     * Updates the value of the store object and returns true if the value changed.
     */
    fun update(value: T?): Boolean {
        val prevValue = valueChanges.value
        val newValue = valueChanges.updateAndGet { value }
        return newValue != prevValue
    }

    /**
     * Updates the value of the store object with the given function.
     */
    fun update(function: (T?) -> T?) {
        valueChanges.updateAndGet(function)
    }

}