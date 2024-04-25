package app.di.datasource

import core.data.datasource.http.HttpSource
import org.koin.dsl.module

val ProvidesHttpSource = module {
    single { HttpSource() }
}