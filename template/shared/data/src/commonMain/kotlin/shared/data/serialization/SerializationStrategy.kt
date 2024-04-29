package shared.data.serialization

import kotlin.reflect.KClass

/**
 * A strategy interface for converting objects of type [T] to and from strings.
 *
 * @param T The type of the object to convert.
 */
interface SerializationStrategy<T : Any> {

    /**
     * Converts a string representation to an object of type [T].
     *
     * @param from The string to convert.
     * @return An object of type [T], or null if conversion fails.
     */
    fun toObject(from: String): T?

    /**
     * Converts an object of type [T] to its string representation.
     *
     * @param from The object to convert.
     * @return The string representation of the object.
     */
    fun toString(from: T): String?

    /**
     * Gets the type of the serialized object.
     *
     * @return The class representing the type [T].
     */
    fun getType(): KClass<T>

}