package kotli.app.presentation.passcode.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * Data class representing passcode state.
 * */
@Serializable
data class PasscodeState(
    val encodedCode: String,
    val unlockAttempts: Int,
    val unlockTime: Long,
    @Transient val decodedCode: String? = null
)