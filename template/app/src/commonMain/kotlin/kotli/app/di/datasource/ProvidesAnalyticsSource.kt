package kotli.app.di.datasource

import kotli.app.datasource.analytics.AppAnalyticsSource
import shared.data.source.analytics.AnalyticsSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesAnalyticsSource = module {
    single { AppAnalyticsSource() }.bind(AnalyticsSource::class)
}