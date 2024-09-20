package kotli.app.data.source.ai.gemini

import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import kotli.app.data.source.ai.AiSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.mapNotNull

class GeminiAiSource(
    private val apiKey: String = "GEMINI_API_KEY"
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
        return if (apiKey == "GEMINI_API_KEY") {
            flowOf("Please provide a valid apiKey value for GeminiAiSource instance.")
        } else {
            flash.generateContentStream(prompt)
                .mapNotNull { response -> response.text }
        }
    }
}