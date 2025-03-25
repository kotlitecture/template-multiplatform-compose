@file:Suppress("UNCHECKED_CAST")

package shared.data.source.settings.multiplatform

import com.russhwolf.settings.Settings
import shared.data.source.encoding.EncodingStrategy
import shared.data.source.settings.SettingsSource

/**
 * Key-value data source implementation using [Settings](https://github.com/russhwolf/multiplatform-settings#no-arg-module).
 */
class MultiplatformSettingsSource : SettingsSource() {

    private val settings by lazy { Settings() }

    override suspend fun <T : Any> save(
        key: String,
        value: T?,
        encodingStrategy: EncodingStrategy<T>
    ) {
        if (value == null) {
            remove(key, encodingStrategy)
            return
        }
        when (value) {
            is String -> settings.putString(key, value)
            is Boolean -> settings.putBoolean(key, value)
            is Int -> settings.putInt(key, value)
            is Long -> settings.putLong(key, value)
            is Float -> settings.putFloat(key, value)
            is Double -> settings.putDouble(key, value)
            else -> settings.putString(key, encodingStrategy.encode(value))
        }
    }

    override suspend fun <T : Any> read(
        key: String,
        encodingStrategy: EncodingStrategy<T>
    ): T? {
        val value: Any? = when (encodingStrategy.getType()) {
            String::class -> settings.getStringOrNull(key)
            Boolean::class -> settings.getBooleanOrNull(key)
            Int::class -> settings.getIntOrNull(key)
            Long::class -> settings.getLongOrNull(key)
            Float::class -> settings.getFloatOrNull(key)
            Double::class -> settings.getDoubleOrNull(key)
            else -> settings.getStringOrNull(key)?.let(encodingStrategy::decode)
        }
        return value as? T
    }

    override suspend fun <T : Any> remove(
        key: String,
        encodingStrategy: EncodingStrategy<T>
    ): T? {
        val prev = read(key, encodingStrategy)
        settings.remove(key)
        return prev
    }

    override suspend fun clear() {
        settings.clear()
    }
}