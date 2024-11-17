@file:Suppress("UNCHECKED_CAST")

package shared.data.source.encoding

import kotlin.reflect.KClass

/**
 * A [EncodingStrategy] implementation that does not actually perform serialization and throws an exception instead.
 *
 * @param T The type of object.
 * @property type The class representing the type of object.
 */
data class DefaultEncodingStrategy<T : Any>(private val type: KClass<T>) :
    EncodingStrategy<T> {

    override fun decode(from: String): T {
        val decoded: Any? = when (type) {
            String::class -> from
            Boolean::class -> from.toBoolean()
            Int::class -> from.toIntOrNull()
            Long::class -> from.toLongOrNull()
            Float::class -> from.toFloatOrNull()
            Double::class -> from.toDoubleOrNull()
            ByteArray::class -> ByteArrayEncodingStrategy.decode(from)
            else -> throw IllegalStateException("use another SerializationStrategy to perform serialization of type $type")
        }
        return decoded as T
    }

    override fun encode(from: T): String {
        return when (type) {
            String::class -> from.toString()
            Boolean::class -> from.toString()
            Int::class -> from.toString()
            Long::class -> from.toString()
            Float::class -> from.toString()
            Double::class -> from.toString()
            ByteArray::class -> ByteArrayEncodingStrategy.encode(from as ByteArray)
            else -> throw IllegalStateException("use another SerializationStrategy to perform serialization of type $type")
        }
    }

    override fun getType(): KClass<T> {
        return type
    }
}