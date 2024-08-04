package kotli.app.presentation.passcode.state

import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

/**
 * Data class representing passcode state.
 * */
@Serializable
data class PasscodeState(
    val encodedCode: String,
    val unlockAttempts: Int = 0,
    val unlockTime: Long = Clock.System.now().toEpochMilliseconds(),
)