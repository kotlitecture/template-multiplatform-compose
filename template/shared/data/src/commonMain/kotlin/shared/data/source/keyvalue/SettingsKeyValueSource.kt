@file:Suppress("UNCHECKED_CAST")

package shared.data.source.keyvalue

import com.russhwolf.settings.Settings
import shared.data.serialization.SerializationStrategy

/**
 * Key-value data source implementation using [Settings](https://github.com/russhwolf/multiplatform-settings#no-arg-module).
 */
open class SettingsKeyValueSource : KeyValueSource() {

    protected val settings by lazy { Settings() }

    override suspend fun <T : Any> save(
        key: String,
        value: T?,
        serializationStrategy: SerializationStrategy<T>
    ) {
        if (value == null) {
            remove(key, serializationStrategy)
            return
        }
        when (value) {
            is String -> settings.putString(key, value)
            is Boolean -> settings.putBoolean(key, value)
            is Int -> settings.putInt(key, value)
            is Long -> settings.putLong(key, value)
            is Float -> settings.putFloat(key, value)
            is Double -> settings.putDouble(key, value)
            else -> settings.putString(key, serializationStrategy.toString(value)!!)
        }
    }

    override suspend fun <T : Any> read(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T? {
        val value: Any? = when (serializationStrategy.getType()) {
            String::class -> settings.getStringOrNull(key)
            Boolean::class -> settings.getBooleanOrNull(key)
            Int::class -> settings.getIntOrNull(key)
            Long::class -> settings.getLongOrNull(key)
            Float::class -> settings.getFloatOrNull(key)
            Double::class -> settings.getDoubleOrNull(key)
            else -> settings.getStringOrNull(key)?.let(serializationStrategy::toObject)
        }
        return value as? T
    }

    override suspend fun <T : Any> remove(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T? {
        val prev = read(key, serializationStrategy)
        settings.remove(key)
        return prev
    }

    override suspend fun clear() {
        settings.clear()
    }
}