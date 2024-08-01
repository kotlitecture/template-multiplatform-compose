package shared.data.source.encryption.korlibs

import shared.data.source.encryption.BasicEncryptionSource
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource

open class KorlibsEncryptionSource : EncryptionSource {

    private val source = BasicEncryptionSource(
        AesResolver()
    )

    override fun encrypt(data: String, method: EncryptionMethod): String {
        return source.encrypt(data, method)
    }

    override fun decrypt(data: String, method: EncryptionMethod): String {
        return source.decrypt(data, method)
    }

}