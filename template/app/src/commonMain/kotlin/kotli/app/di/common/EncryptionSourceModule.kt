package kotli.app.di.common

import kotli.app.common.data.source.encryption.AppEncryptionSource
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.data.source.encryption.EncryptionSource

val encryptionSourceModule = module {
    single { AppEncryptionSource() }.bind(EncryptionSource::class)
}