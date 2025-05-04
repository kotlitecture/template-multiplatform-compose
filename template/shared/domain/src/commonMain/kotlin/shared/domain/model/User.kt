package shared.domain.model

import kotlinx.serialization.Serializable

/**
 * Represents a user in the system.
 *
 * @property firstName The first name of the user.
 * @property lastName The last name of the user.
 */
@Serializable
data class User(
    val firstName: String,
    val lastName: String
)
