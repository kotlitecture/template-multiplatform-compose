package shared.data.source.encryption

@Suppress("UNCHECKED_CAST")
open class BasicEncryptionSource(
    vararg resolvers: EncryptionResolver<*>
) : EncryptionSource {

    private val byType by lazy { resolvers.associateBy { resolver -> resolver.methodType } }

    override fun encrypt(data: String, method: EncryptionMethod): String {
        val encoded = get(method).encrypt(data.encodeToByteArray(), method)
        return encoded.toHexString()
    }

    override fun decrypt(data: String, method: EncryptionMethod): String {
        val decoded = get(method).decrypt(data.hexToByteArray(), method)
        return decoded.decodeToString()
    }

    private fun get(method: EncryptionMethod): EncryptionResolver<EncryptionMethod> {
        val type = method::class
        val resolver = byType[type] ?: error("unknown type $type")
        return resolver as EncryptionResolver<EncryptionMethod>
    }

}