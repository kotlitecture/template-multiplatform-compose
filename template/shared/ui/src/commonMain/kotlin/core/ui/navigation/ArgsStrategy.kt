package core.ui.navigation

import androidx.collection.MutableScatterMap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
    @Composable
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
    data class JsonString<D>(private val serializer: KSerializer<D>) : ArgsStrategy<D> {

        @Composable
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
    object InMemory : ArgsStrategy<Any> {
        private val cache = MutableScatterMap<String, Any?>()

        @Composable
        override fun toObject(from: String): Any? {
            val data = cache[from]
            DisposableEffect(from) {
                onDispose {
                    cache.remove(from)
                }
            }
            return data
        }

        override fun toString(from: Any): String {
            val id = "${from::class}_${from.hashCode()}"
            cache[id] = from
            return id
        }
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
         * Creates a [ArgsStrategy] that stores objects in memory.
         *
         * @return An instance of [InMemory].
         */
        @Suppress("UNCHECKED_CAST")
        fun <D> memory(): ArgsStrategy<D> = InMemory as ArgsStrategy<D>
    }
}