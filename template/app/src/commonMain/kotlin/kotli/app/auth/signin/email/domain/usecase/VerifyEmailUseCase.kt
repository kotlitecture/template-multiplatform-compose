package kotli.app.auth.signin.email.domain.usecase

import kotli.app.auth.common.domain.repository.AuthRepository

class VerifyEmailUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke(email: String, otp: String) {
        authRepository.verifyEmail(email, otp)
    }
}