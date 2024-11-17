package kotli.app.feature.theme.provide.domain.usecase

import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import kotli.app.feature.theme.provide.domain.repository.ThemeRepository

class RestoreThemeUseCase(
    private val repository: ThemeRepository
) {

    suspend fun invoke(): ThemeConfigModel? {
        return runCatching { repository.restore() }.getOrNull()
    }
}