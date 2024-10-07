package kotli.app.di.data

import kotli.app.common.data.source.ai.AiSource
import kotli.app.common.data.source.ai.gemini.GeminiAiSource
import org.koin.dsl.bind
import org.koin.dsl.module

val aiSourceModule = module {
    // https://ai.google.dev/gemini-api/docs/api-key
    single<GeminiAiSource> { GeminiAiSource() }.bind(AiSource::class)
}