package shared.data.source.encryption.korlibs

import korlibs.crypto.AES
import korlibs.crypto.Padding
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionResolver
import kotlin.reflect.KClass

internal class AesResolver : EncryptionResolver<EncryptionMethod.AES> {

    private val keyLength = 16
    private val keyPadChar = ' '
    private val padding = Padding.PKCS7Padding

    override val methodType: KClass<EncryptionMethod.AES> = EncryptionMethod.AES::class

    override fun encrypt(data: ByteArray, method: EncryptionMethod.AES): ByteArray {
        val key = method.password.padEnd(keyLength, keyPadChar).encodeToByteArray()
        return AES.encryptAesCbc(data, key, key, padding)
    }

    override fun decrypt(data: ByteArray, method: EncryptionMethod.AES): ByteArray {
        val key = method.password.padEnd(keyLength, keyPadChar).encodeToByteArray()
        return AES.decryptAesCbc(data, key, key, padding)
    }
}