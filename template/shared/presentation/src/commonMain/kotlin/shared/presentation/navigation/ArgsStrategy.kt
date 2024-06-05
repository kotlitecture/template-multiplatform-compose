package shared.presentation.navigation

import androidx.compose.runtime.Immutable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

/**
 * A strategy interface for converting objects of type [D] to and from strings.
 *
 * @param D The type of the object to convert.
 */
interface ArgsStrategy<D> {

    /**
     * Converts a string representation to an object of type [D].
     *
     * @param from The string to convert.
     * @return An object of type [D], or null if conversion fails.
     */
    fun toObject(from: String): D?

    /**
     * Converts an object of type [D] to its string representation.
     *
     * @param from The object to convert.
     * @return The string representation of the object.
     */
    fun toString(from: D): String?

    /**
     * A [ArgsStrategy] implementation that uses JSON serialization for conversion.
     *
     * @param serializer The serializer for the object type [D].
     */
    @Immutable
    data class JsonString<D>(private val serializer: KSerializer<D>) : ArgsStrategy<D> {

        override fun toObject(from: String): D {
            return Json.decodeFromString(serializer, from)
        }

        override fun toString(from: D): String {
            return Json.encodeToString(serializer, from)
        }

    }

    /**
     * A [ArgsStrategy] implementation that stores objects in memory.
     */
    @Immutable
    object NoArgs : ArgsStrategy<Any> {
        override fun toObject(from: String): Any? = null
        override fun toString(from: Any): String? = null
    }

    companion object {
        /**
         * Creates a [ArgsStrategy] that uses JSON serialization.
         *
         * The passed serializer is created automatically once the type [D] is marked with [kotlinx.serialization.Serializable] annotation.
         * Once it is done, use the static method serializer() of type [D].
         *
         * @param serializer The serializer for the object type [D].
         * @return An instance of [JsonString].
         */
        fun <D> json(serializer: KSerializer<D>): ArgsStrategy<D> = JsonString(serializer)

        /**
         * Creates a [ArgsStrategy] that do nothing.
         *
         * @return An instance of [NoArgs].
         */
        @Suppress("UNCHECKED_CAST")
        fun <D> noArgs(): ArgsStrategy<D> = NoArgs as ArgsStrategy<D>
    }
}