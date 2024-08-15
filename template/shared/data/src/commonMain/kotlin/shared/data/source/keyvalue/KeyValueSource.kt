package shared.data.source.keyvalue

import shared.data.serialization.SerializationStrategy
import shared.data.source.DataSource

/**
 * Provides functionality to save, read, remove, and clear key-value pairs.
 */
abstract class KeyValueSource : DataSource {

    /**
     * Reads the value associated with the specified key from a storage.
     *
     * @param key The key to read.
     * @return The value associated with the key, or `null` if the key does not exist or cannot be decrypted.
     * @throws IllegalStateException if serialization/deserialization fails or if the requested type is not supported.
     */
    suspend inline fun <reified T : Any> read(key: String): T? {
        return read(key, SerializationStrategy.no())
    }

    /**
     * Saves the specified key-value pair into a storage.
     *
     * @param key The key to save.
     * @param value The value to save.
     * @throws IllegalStateException if serialization/deserialization fails or if the requested type is not supported.
     */
    suspend inline fun <reified T : Any> save(key: String, value: T?) {
        save(key, value, SerializationStrategy.no())
    }

    /**
     * Removes the value associated with the specified key.
     *
     * @param key The key to remove.
     * @throws IllegalStateException if serialization/deserialization fails or if the requested type is not supported.
     *
     * @return The removed value associated with the key, or `null` if the key does not exist.
     */
    suspend inline fun <reified T : Any> remove(key: String): T? {
        return remove(key, SerializationStrategy.no())
    }

    /**
     * Saves the specified key-value pair.
     *
     * @param key The key to save.
     * @param value The value to save.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     */
    abstract suspend fun <T : Any> save(
        key: String,
        value: T?,
        serializationStrategy: SerializationStrategy<T>
    )

    /**
     * Reads the value associated with the specified key.
     *
     * @param key The key to read.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     * @return The value associated with the key, or `null` if the key does not exist.
     */
    abstract suspend fun <T : Any> read(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T?

    /**
     * Removes the value associated with the specified key.
     *
     * @param key The key to remove.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     *
     * @return The removed value associated with the key, or `null` if the key does not exist.
     */
    abstract suspend fun <T : Any> remove(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T?

    /**
     * Clears all key-value pairs.
     */
    abstract suspend fun clear()

}