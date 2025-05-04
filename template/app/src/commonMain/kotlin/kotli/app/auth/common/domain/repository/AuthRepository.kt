package kotli.app.auth.common.domain.repository

import kotli.app.auth.common.domain.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun getAuthUser(): Flow<AuthUser?>

    suspend fun signInWithEmail(email: String)

    suspend fun verifyEmail(email: String, otp: String)

    suspend fun signInWithGoogle()

    suspend fun signOut()
}