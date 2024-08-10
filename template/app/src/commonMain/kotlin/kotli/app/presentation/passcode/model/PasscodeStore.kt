package kotli.app.presentation.passcode.model

import shared.data.source.encryption.EncryptionMethod
import shared.presentation.store.DataState
import shared.presentation.store.Store
import kotlin.time.Duration.Companion.seconds

/**
 * Represents the state related to passcode configuration and management.
 *
 * @param persistentKey The key used for persistent storage of the entered passcode.
 * @param passcodeLength The length of the passcode.
 * @param unlockAttemptsCount The maximum number of unlock attempts allowed.
 * @param resumeTimeout The timeout for resuming the passcode lock in milliseconds.
 */
data class PasscodeStore(
    val persistentKey: String = "passcode_config",
    val passcodeLength: Int = 4,
    val unlockAttemptsCount: Int = 5,
    val resumeTimeout: Long = 5.seconds.inWholeMilliseconds,
    val encryptionMethod: (code: String) -> EncryptionMethod = EncryptionMethod::AES
) : Store() {

    val passcodeState = DataState<PasscodeState>()
    val lockState = DataState(LockState.UNDEFINED)

}