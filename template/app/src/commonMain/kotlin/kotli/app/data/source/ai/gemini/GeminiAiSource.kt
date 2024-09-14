package kotli.app.data.source.ai.gemini

import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import kotli.app.data.source.ai.AiSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class GeminiAiSource(
    apiKey: String
) : AiSource {

    private val flash by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = apiKey
        )
    }

    private val pro by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )
    }

    override suspend fun reply(prompt: String): Flow<String> {
        return flash.generateContentStream(prompt)
            .mapNotNull { response -> response.text }
    }
}