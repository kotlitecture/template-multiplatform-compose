package shared.data.source.encryption

interface EncryptionSource {

    fun encrypt(data: String, method: EncryptionMethod): String

    fun decrypt(data: String, method: EncryptionMethod): String

}