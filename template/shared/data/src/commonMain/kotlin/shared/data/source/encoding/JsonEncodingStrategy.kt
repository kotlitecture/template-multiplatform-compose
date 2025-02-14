package shared.data.source.encoding

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

/**
 * A [EncodingStrategy] implementation that uses JSON serialization for conversion.
 *
 * @param serializer The serializer for the object type [T].
 */
data class JsonEncodingStrategy<T : Any>(
    private val serializer: KSerializer<T>,
    private val type: KClass<T>
) : EncodingStrategy<T> {

    override fun decode(from: String): T {
        return Json.decodeFromString(serializer, from)
    }

    override fun encode(from: T): String {
        return Json.encodeToString(serializer, from)
    }

    override fun getType(): KClass<T> {
        return type
    }

}