package kotli.app.feature.theme.provide.data

import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import kotli.app.feature.theme.provide.domain.repository.ThemeRepository
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class ThemeRepositoryImpl(
    private val key: String,
    private val keyValueSource: KeyValueSource
) : ThemeRepository {

    private val strategy = SerializationStrategy.json(ThemeConfigModel.serializer())

    override suspend fun restore(): ThemeConfigModel? {
        return keyValueSource.read(key, strategy)
    }

    override suspend fun store(model: ThemeConfigModel) {
        keyValueSource.save(key, model, strategy)
    }
}