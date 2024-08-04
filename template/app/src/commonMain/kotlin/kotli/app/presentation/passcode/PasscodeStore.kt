package kotli.app.presentation.passcode

import kotli.app.presentation.passcode.state.PasscodeState
import shared.presentation.store.DataState
import shared.presentation.store.Store
import kotlin.time.Duration.Companion.seconds

/**
 * Represents the state related to passcode configuration and management.
 *
 * @param passcodeLength The length of the passcode.
 * @param unlockAttemptsCount The maximum number of unlock attempts allowed.
 * @param resumeTimeout The timeout for resuming the passcode lock in milliseconds.
 * @param passcodeConfigKey The key used for persistent storage of the entered passcode.
 */
data class PasscodeStore(
    val passcodeLength: Int = 4,
    val unlockAttemptsCount: Int = 5,
    val resumeTimeout: Long = 1.seconds.inWholeMilliseconds,
    val passcodeConfigKey: String = "passcode_config",
) : Store() {

    val passcodeState = DataState<PasscodeState>()

}