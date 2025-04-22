package kotli.app.auth.signin.email.domain.usecase

import kotli.app.auth.common.domain.repository.AuthRepository

class SignInWithEmailUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke(email: String) {
        authRepository.signInWithEmail(email)
    }
}