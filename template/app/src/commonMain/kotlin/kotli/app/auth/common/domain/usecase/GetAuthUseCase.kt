package kotli.app.auth.common.domain.usecase

import kotli.app.auth.common.domain.model.AuthUser
import kotli.app.auth.common.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class GetAuthUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke(): Flow<AuthUser?> {
        return authRepository.getAuthUser()
    }
}