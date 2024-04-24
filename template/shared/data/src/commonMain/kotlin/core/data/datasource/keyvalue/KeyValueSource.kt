package core.data.datasource.keyvalue

import core.data.datasource.DataSource
import core.data.serialization.SerializationStrategy

/**
 * Provides functionality to save, read, remove, and clear key-value pairs.
 */
interface KeyValueSource : DataSource {

    /**
     * Saves the specified key-value pair.
     *
     * @param key The key to save.
     * @param value The value to save.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     */
    suspend fun <T : Any> save(
        key: String,
        value: T,
        serializationStrategy: SerializationStrategy<T>
    )

    /**
     * Reads the value associated with the specified key.
     *
     * @param key The key to read.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     * @return The value associated with the key, or `null` if the key does not exist.
     */
    suspend fun <T : Any> read(key: String, serializationStrategy: SerializationStrategy<T>): T?

    /**
     * Removes the value associated with the specified key.
     *
     * @param key The key to remove.
     * @param serializationStrategy The serialization strategy used to convert the value to a string.
     *
     * @return The removed value associated with the key, or `null` if the key does not exist.
     */
    suspend fun <T : Any> remove(key: String, serializationStrategy: SerializationStrategy<T>): T?

    /**
     * Clears all key-value pairs.
     */
    suspend fun clear()

}