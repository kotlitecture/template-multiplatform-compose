package kotli.app.theme.provide.domain.repository

import kotli.app.theme.provide.domain.model.ThemeConfigModel

interface ThemeRepository {

    suspend fun restore(): ThemeConfigModel?

    suspend fun store(model: ThemeConfigModel)

}