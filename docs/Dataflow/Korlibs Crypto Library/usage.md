# Usage

## Overview

The API can be accessed through:
- `shared.data.source.encryption.EncryptionSource` - facade interface at the core module level.

Facade **EncryptionSource** provides the following methods:

- `encrypt(text: String, method: EncryptionMethod): String` - Encrypts the given text using the specified encryption method.
- `decrypt(text: String, method: EncryptionMethod): String` - Decrypts the given text using the specified encryption method.

## Examples

The **facade** is pre-configured via dependency injection (DI) as singletons in `app.common.CommonConfig`.

To start using, just inject it to your DI managed class.

The functionality can be extended with time (or added on your own).

### Encryption / Decryption

```kotlin
class BasicEncryptionViewModel(
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    override fun doBind() = async {
        val method = EncryptionMethod.AES("1234")
        val encryptedText = encryptionSource.encrypt("my_text_to_encrypt", method)
        val decryptedText = encryptionSource.decrypt(encryptedText, method)
    }
}
```

### Hashing

```kotlin
class BasicHashingViewModel(
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    override fun doBind() = async {
        val salt = ByteArrayStrategy.toString(Random.nextBytes(16))
        val method = EncryptionMethod.PBKDF2(salt)
        val hashedPassword = encryptionSource.encrypt("my_password_to_hash", method)
    }
}
```
