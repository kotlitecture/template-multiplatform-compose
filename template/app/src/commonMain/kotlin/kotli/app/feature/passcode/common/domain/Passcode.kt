package kotli.app.feature.passcode.common.domain

import kotlinx.serialization.Serializable

@Serializable
data class Passcode(
    val salt: String,
    val encodedCode: String,
    val unlockAttempts: Int,
    val unlockTime: Long
)