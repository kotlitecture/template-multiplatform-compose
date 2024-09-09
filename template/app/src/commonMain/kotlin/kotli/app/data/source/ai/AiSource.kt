package kotli.app.data.source.ai

import kotlinx.coroutines.flow.Flow

interface AiSource {

    suspend fun generateContent(prompt: String): Flow<String>

}