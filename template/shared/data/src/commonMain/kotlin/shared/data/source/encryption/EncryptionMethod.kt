package shared.data.source.encryption

sealed class EncryptionMethod {

    data class AES(val password: String) : EncryptionMethod()

}