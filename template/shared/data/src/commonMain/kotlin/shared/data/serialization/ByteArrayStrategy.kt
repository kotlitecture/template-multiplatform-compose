package shared.data.serialization

import kotlin.io.encoding.Base64
import kotlin.reflect.KClass

/**
 * A [SerializationStrategy] implementation that serialize only ByteArray.
 */
object ByteArrayStrategy : SerializationStrategy<ByteArray> {

    override fun toObject(from: String): ByteArray {
        return Base64.UrlSafe.decode(from)
    }

    override fun toString(from: ByteArray): String {
        return Base64.UrlSafe.encode(from)
    }

    override fun getType(): KClass<ByteArray> {
        return ByteArray::class
    }

}