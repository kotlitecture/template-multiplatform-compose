package shared.data.source.keyvalue

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.byteArrayPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import okio.Path.Companion.toPath
import shared.data.serialization.SerializationStrategy
import kotlin.reflect.KClass

/**
 * Key-value data source implementation using [Jetpack DataStore].
 *
 * @param app The application context.
 */
@Suppress("UNCHECKED_CAST")
class DataStoreSource(
    private val path: String
) : KeyValueSource() {

    private val dataStore: DataStore<Preferences> by lazy {
        PreferenceDataStoreFactory.createWithPath { path.toPath() }
    }

    override suspend fun <T : Any> save(
        key: String,
        value: T?,
        serializationStrategy: SerializationStrategy<T>
    ) {
        if (value == null) {
            remove(key, serializationStrategy)
        } else {
            dataStore.edit { prefs ->
                val prefsKey = defineKey(key, serializationStrategy.getType())
                if (prefsKey != null) {
                    prefs[prefsKey] = value
                } else {
                    val jsonKey = stringPreferencesKey(key)
                    prefs[jsonKey] = serializationStrategy.toString(value).orEmpty()
                }
            }
        }
    }

    override suspend fun <T : Any> read(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T? {
        val prefsKey = defineKey(key, serializationStrategy.getType())
        val value = if (prefsKey != null) {
            dataStore.data.first()[prefsKey]
        } else {
            val jsonKey = stringPreferencesKey(key)
            val jsonString = dataStore.data.first()[jsonKey] ?: return null
            serializationStrategy.toObject(jsonString)
        }
        return value
    }

    override suspend fun <T : Any> remove(
        key: String,
        serializationStrategy: SerializationStrategy<T>
    ): T? {
        val prev = read(key, serializationStrategy)
        dataStore.edit { prefs ->
            prefs.remove(
                defineKey(key, serializationStrategy.getType())
                    ?: stringPreferencesKey(key)
            )
        }
        return prev
    }

    override suspend fun clear() {
        dataStore.edit { prefs -> prefs.clear() }
    }

    private fun <T : Any> defineKey(key: String, type: KClass<T>): Preferences.Key<T>? {
        val prefsKey = when (type) {
            String::class -> stringPreferencesKey(key)
            Boolean::class -> booleanPreferencesKey(key)
            Int::class -> intPreferencesKey(key)
            Long::class -> longPreferencesKey(key)
            Float::class -> floatPreferencesKey(key)
            Double::class -> doublePreferencesKey(key)
            ByteArray::class -> byteArrayPreferencesKey(key)
            else -> null
        }
        return prefsKey as? Preferences.Key<T>
    }

}