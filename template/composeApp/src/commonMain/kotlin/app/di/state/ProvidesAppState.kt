package app.di.state

import app.AppNavigationRouter
import app.AppState
import org.koin.dsl.module

val ProvidesAppState = module {
    single { AppState() }
    single { AppNavigationRouter() }
}