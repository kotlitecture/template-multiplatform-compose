## Overview

The API can be accessed through:
- `shared.data.source.encryption.EncryptionSource` - facade interface at the core module level.
- `app.data.source.encryption.AppEncryptionSource` - decorator class at the app level.

The difference is that the class serves as a **decorator** and can provide extra methods without impacting facade implementations.

Facade **EncryptionSource** provides the following methods:

- `encrypt(text: String, method: EncryptionMethod): String` - Encrypts the given text using the specified encryption method.
- `decrypt(text: String, method: EncryptionMethod): String` - Decrypts the given text using the specified encryption method.

## Example

Both the **facade** and **decorator** are pre-configured via dependency injection (DI) as singletons in `app.di.data.EncryptionSourceModule`.

To start using, just inject it to your DI managed class.

```kotlin
class BasicEncryptionViewModel(
    private val encryptionSource: EncryptionSource
) : BaseViewModel() {

    override fun doBind() {
        launchAsync {
            val method = EncryptionMethod.AES("1234")
            val encryptedText = encryptionSource.encrypt("my_text_to_encrypt", method)
            val decryptedText = encryptionSource.decrypt(encryptedText, method)
        }
    }
}
```