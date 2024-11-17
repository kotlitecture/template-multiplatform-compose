package kotli.app.feature.theme.provide.data

import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import kotli.app.feature.theme.provide.domain.repository.ThemeRepository
import shared.data.source.encoding.EncodingStrategy
import shared.data.source.settings.SettingsSource

class ThemeRepositoryImpl(
    private val key: String,
    private val settingsSource: SettingsSource
) : ThemeRepository {

    private val strategy = EncodingStrategy.json(ThemeConfigModel.serializer())

    override suspend fun restore(): ThemeConfigModel? {
        return settingsSource.read(key, strategy)
    }

    override suspend fun store(model: ThemeConfigModel) {
        settingsSource.save(key, model, strategy)
    }
}