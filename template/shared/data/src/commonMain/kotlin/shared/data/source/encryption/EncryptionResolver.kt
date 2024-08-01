package shared.data.source.encryption

import kotlin.reflect.KClass

interface EncryptionResolver<M : EncryptionMethod> {

    val methodType: KClass<M>

    fun encrypt(data: ByteArray, method: M): ByteArray

    fun decrypt(data: ByteArray, method: M): ByteArray

}