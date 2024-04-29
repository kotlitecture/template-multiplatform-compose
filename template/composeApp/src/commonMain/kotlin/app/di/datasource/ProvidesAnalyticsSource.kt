package app.di.datasource

import app.datasource.analytics.AppAnalyticsSource
import shared.data.datasource.analytics.AnalyticsSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesAnalyticsSource = module {
    single { AppAnalyticsSource() }.bind(AnalyticsSource::class)
}