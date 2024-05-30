package shared.data.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

/**
 * A [SerializationStrategy] implementation that uses JSON serialization for conversion.
 *
 * @param serializer The serializer for the object type [T].
 */
data class JsonStrategy<T : Any>(
    private val serializer: KSerializer<T>,
    private val type: KClass<T>
) : SerializationStrategy<T> {

    override fun toObject(from: String): T {
        return Json.decodeFromString(serializer, from)
    }

    override fun toString(from: T): String {
        return Json.encodeToString(serializer, from)
    }

    override fun getType(): KClass<T> {
        return type
    }

}