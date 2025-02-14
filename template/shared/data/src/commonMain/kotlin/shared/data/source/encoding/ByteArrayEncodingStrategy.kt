package shared.data.source.encoding

import kotlin.io.encoding.Base64
import kotlin.reflect.KClass

/**
 * A [EncodingStrategy] implementation that serialize only ByteArray.
 */
object ByteArrayEncodingStrategy : EncodingStrategy<ByteArray> {

    override fun decode(from: String): ByteArray {
        return Base64.UrlSafe.decode(from)
    }

    override fun encode(from: ByteArray): String {
        return Base64.UrlSafe.encode(from)
    }

    override fun getType(): KClass<ByteArray> {
        return ByteArray::class
    }

}