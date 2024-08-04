package kotli.app.presentation.passcode.usecase

import shared.data.source.encryption.EncryptionMethod

abstract class PasscodeUseCase {

    protected fun encryptionMethod(code: String): EncryptionMethod = EncryptionMethod.AES(code)

    protected fun unknownError(): Nothing = error("unknown error")

}