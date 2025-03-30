package shared.data.source.ai

import kotlinx.coroutines.flow.Flow
import shared.data.source.DataSource

interface AiSource : DataSource {

    suspend fun reply(prompt: String): Flow<String>
}