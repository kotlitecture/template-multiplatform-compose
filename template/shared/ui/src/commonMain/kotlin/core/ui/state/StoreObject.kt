package core.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.mapNotNull

/**
 * An immutable store object that holds a value of type [T].
 *
 * @param T the type of the value stored in the object.
 * @property value The initial value of the store object.
 * @property valueReply The number of initial values to be replayed to collectors of the [asFlow] flow.
 * @property valueBufferCapacity The additional buffer capacity for the [asFlow] flow.
 * @property onChanged A lambda function invoked when the value of the store object changes.
 */
@Immutable
data class StoreObject<T>(
    private val value: T? = null,
    private val valueReply: Int = 1,
    private val valueBufferCapacity: Int = 1,
    private val onChanged: ((prevValue: T?, newValue: T?) -> Unit)? = null,
) {

    private var prevValue: T? = null
    private var currentValue: T? = value

    private val valueChanges = lazy {
        val processor = MutableSharedFlow<T?>(
            replay = valueReply,
            extraBufferCapacity = valueBufferCapacity
        )
        processor.tryEmit(currentValue)
        processor
    }

    /**
     * Returns the store object as a [MutableState] object.
     */
    @Stable
    @Composable
    fun asState(): State<T?> = asFlow()
        .collectAsState(initial = currentValue)

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
    fun asStateNotNull(): State<T> = asFlow()
        .mapNotNull { it }
        .collectAsState(initial = currentValue!!)

    /**
     * Returns the value of the store object as a non-nullable type [T].
     */
    @Composable
    fun asStateValueNotNull(): T = asStateNotNull().value

    /**
     * Returns the store object as a flow of type [T].
     */
    @Stable
    fun asFlow(): Flow<T?> = valueChanges.value

    /**
     * Gets the non-nullable value of the store object.
     */
    fun getNotNull(): T = currentValue!!

    /**
     * Clears the value of the store object to the initial state.
     */
    fun clear() = set(value)

    /**
     * Gets the value of the store object.
     */
    fun get(): T? = currentValue

    /**
     * Gets the previous value of the store object.
     */
    fun getPrev(): T? = prevValue

    /**
     * Checks if the current value is null.
     * @return true if the current value is null, false otherwise.
     */
    fun isNull(): Boolean = currentValue == null

    /**
     * Checks if the current value is not null.
     * @return true if the current value is not null, false otherwise.
     */
    fun isNotNull(): Boolean = !isNull()

    /**
     * Sets the value of the store object and emits it to collectors if it has changed.
     *
     * @param value The new value to set.
     * @return `true` if the value has changed, `false` otherwise.
     */
    fun set(value: T?): Boolean {
        val changed = currentValue != value
        prevValue = currentValue
        currentValue = value
        if (changed) {
            onChanged?.invoke(prevValue, value)
            if (valueChanges.isInitialized()) {
                val changes = valueChanges.value
                changes.tryEmit(value)
            }
        }
        return changed
    }

}