package kotli.app.theme.provide.domain.usecase

import kotli.app.theme.provide.domain.model.ThemeConfigModel
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource

class RestoreThemeUseCase(
    private val keyValueSource: KeyValueSource
) {

    private val strategy = SerializationStrategy.json(ThemeConfigModel.serializer())

    suspend fun invoke(key: String): ThemeConfigModel? {
        return keyValueSource.read(key, strategy)
    }
}