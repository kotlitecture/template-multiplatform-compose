package kotli.app.di.data

import kotli.app.data.source.ai.AiSource
import kotli.app.data.source.ai.gemini.GeminiAiSource
import org.koin.dsl.module

val aiSourceModule = module {
    // https://ai.google.dev/gemini-api/docs/api-key
    single<AiSource> { GeminiAiSource() }
}