package kotli.app.feature.theme.provide.domain.usecase

import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class StoreThemeUseCase(
    private val keyValueSource: KeyValueSource
) {

    private val strategy = SerializationStrategy.json(ThemeConfigModel.serializer())

    suspend fun invoke(key: String, model: ThemeConfigModel) {
        keyValueSource.save(key, model, strategy)
    }
}