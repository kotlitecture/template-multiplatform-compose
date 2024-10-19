package kotli.app.feature.theme.provide.domain.usecase

import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import kotli.app.feature.theme.provide.domain.repository.ThemeRepository

class StoreThemeUseCase(
    private val repository: ThemeRepository
) {

    suspend fun invoke(model: ThemeConfigModel) {
        repository.store(model)
    }
}