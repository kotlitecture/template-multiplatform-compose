package kotli.app.data.source.encryption

import shared.data.source.encryption.korlibs.KorlibsEncryptionSource

/**
 * Decorator class for working with encryption.
 *
 * Can provide extra methods without impacting facade implementations.
 */
class AppEncryptionSource : KorlibsEncryptionSource()