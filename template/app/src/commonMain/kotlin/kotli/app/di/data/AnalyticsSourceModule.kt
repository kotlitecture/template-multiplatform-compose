package kotli.app.di.data

import kotli.app.data.source.analytics.AppAnalyticsSource
import shared.data.source.analytics.AnalyticsSource
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsSourceModule = module {
    single { AppAnalyticsSource() }.bind(AnalyticsSource::class)
}