package shared.data.source.encryption.korlibs

import shared.data.source.encryption.BasicEncryptionSource
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource

/**
 * An implementation of the [EncryptionSource] interface using the Korlibs encryption library.
 *
 * This class uses a basic encryption source with an [AesResolver] to perform encryption
 * and decryption operations.
 */
open class KorlibsEncryptionSource : EncryptionSource {

    private val source = BasicEncryptionSource(
        AesResolver(),
        Pbkdf2Resolver()
    )

    override fun encrypt(text: String, method: EncryptionMethod): String {
        return source.encrypt(text, method)
    }

    override fun decrypt(text: String, method: EncryptionMethod): String {
        return source.decrypt(text, method)
    }
}