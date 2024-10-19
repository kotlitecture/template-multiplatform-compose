package kotli.app.feature.passcode.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Passcode(
    val salt: String,
    val encodedCode: String,
    val unlockAttempts: Int,
    val unlockTime: Long
)