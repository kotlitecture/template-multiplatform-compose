package app.di.datasource

import shared.data.datasource.http.HttpSource
import org.koin.dsl.module

val ProvidesHttpSource = module {
    single { HttpSource() }
}