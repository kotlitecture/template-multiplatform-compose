package kotli.app.di.data

import kotli.app.data.source.ai.AiSource
import kotli.app.data.source.ai.gemini.GeminiSource
import kotli.app.data.source.analytics.AppAnalyticsSource
import shared.data.source.analytics.AnalyticsSource
import org.koin.dsl.bind
import org.koin.dsl.module

val aiSourceModule = module {
    single<AiSource> { GeminiSource("API_KEY") }
}