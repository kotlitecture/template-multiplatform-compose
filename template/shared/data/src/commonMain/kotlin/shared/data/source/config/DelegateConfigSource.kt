package shared.data.source.config

import shared.data.serialization.SerializationStrategy

/**
 *
 * Implementation of the [ConfigSource] interface that delegates calls to another [ConfigSource] instance.
 *
 * If the provided source is null, the default values are returned for all keys.
 */
open class DelegateConfigSource(private val source: ConfigSource? = null) : ConfigSource {

    override fun <T : Any> get(
        key: String,
        serializationStrategy: SerializationStrategy<T>,
        defaultValue: () -> T
    ): T {
        return source?.get(key, serializationStrategy, defaultValue) ?: defaultValue()
    }

}