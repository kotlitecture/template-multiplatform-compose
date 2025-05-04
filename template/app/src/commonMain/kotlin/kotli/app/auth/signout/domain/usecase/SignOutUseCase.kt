package kotli.app.auth.signout.domain.usecase

import kotli.app.auth.common.domain.repository.AuthRepository

class SignOutUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke() {
        authRepository.signOut()
    }
}