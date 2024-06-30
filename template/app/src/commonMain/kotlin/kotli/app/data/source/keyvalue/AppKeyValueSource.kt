package kotli.app.data.source.keyvalue

import shared.data.source.keyvalue.SettingsKeyValueSource
import shared.data.serialization.SerializationStrategy

/**
 * Decorator class for working with key-value storage on the app level.
 *
 * Can provide extra methods without impacting facade implementations.
 */
class AppKeyValueSource : SettingsKeyValueSource() {

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

}