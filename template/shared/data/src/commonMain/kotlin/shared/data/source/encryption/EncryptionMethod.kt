package shared.data.source.encryption

/**
 * A sealed class representing different encryption methods.
 */
sealed class EncryptionMethod {

    /**
     * AES encryption method with a specified password.
     *
     * @property password the password used for AES encryption.
     */
    data class AES(val password: String) : EncryptionMethod()
}