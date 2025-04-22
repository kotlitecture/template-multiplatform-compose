package kotli.app.auth.signin.google.domain.usecase

import kotli.app.auth.common.domain.repository.AuthRepository

class SignInWithGoogleUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke() {
        authRepository.signInWithGoogle()
    }
}