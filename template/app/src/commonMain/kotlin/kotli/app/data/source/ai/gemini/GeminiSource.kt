package kotli.app.data.source.ai.gemini

import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import kotli.app.data.source.ai.AiSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class GeminiSource(
    apiKey: String
) : AiSource {

    private val flash = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = apiKey
    )

    private val pro = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = apiKey
    )

    override suspend fun generateContent(prompt: String): Flow<String> {
        return flash.generateContentStream(prompt)
            .mapNotNull { response -> response.text }
    }
}