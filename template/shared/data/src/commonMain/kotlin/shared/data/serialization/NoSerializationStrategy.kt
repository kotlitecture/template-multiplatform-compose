@file:Suppress("UNCHECKED_CAST")

package shared.data.serialization

import kotlin.reflect.KClass

/**
 * A [SerializationStrategy] implementation that does not actually perform serialization and throws an exception instead.
 *
 * @param T The type of object.
 * @property type The class representing the type of object.
 */
data class NoSerializationStrategy<T : Any>(private val type: KClass<T>) :
    SerializationStrategy<T> {

    override fun toObject(from: String): T? {
        return when (type) {
            ByteArray::class -> ByteArrayStrategy.toObject(from) as? T
            else -> throw IllegalStateException("use another SerializationStrategy to perform serialization of type $type")
        }
    }

    override fun toString(from: T): String? {
        return when (type) {
            ByteArray::class -> ByteArrayStrategy.toString(from as ByteArray)
            else -> throw IllegalStateException("use another SerializationStrategy to perform serialization of type $type")
        }
    }

    override fun getType(): KClass<T> {
        return type
    }

}