package kotli.app.theme.provide.domain.usecase

import kotli.app.theme.provide.domain.model.ThemeConfigModel
import kotli.app.theme.provide.domain.repository.ThemeRepository

class StoreThemeUseCase(
    private val repository: ThemeRepository
) {

    suspend fun invoke(model: ThemeConfigModel) {
        runCatching { repository.store(model) }
    }
}