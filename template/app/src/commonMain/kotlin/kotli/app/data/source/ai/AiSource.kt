package kotli.app.data.source.ai

import kotlinx.coroutines.flow.Flow
import shared.data.source.DataSource

interface AiSource : DataSource {

    suspend fun generateContent(prompt: String): Flow<String>

}