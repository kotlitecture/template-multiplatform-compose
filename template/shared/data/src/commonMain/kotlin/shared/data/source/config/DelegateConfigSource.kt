package shared.data.source.config

import shared.data.source.encoding.EncodingStrategy

/**
 *
 * Implementation of the [ConfigSource] interface that delegates calls to another [ConfigSource] instance.
 *
 * If the provided source is null, the default values are returned for all keys.
 */
open class DelegateConfigSource(private val source: ConfigSource? = null) : ConfigSource {

    override fun <T : Any> get(
        key: String,
        encodingStrategy: EncodingStrategy<T>,
        defaultValue: () -> T
    ): T {
        return source?.get(key, encodingStrategy, defaultValue) ?: defaultValue()
    }

}