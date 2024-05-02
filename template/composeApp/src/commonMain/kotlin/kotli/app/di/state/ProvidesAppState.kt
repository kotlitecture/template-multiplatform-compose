package kotli.app.di.state

import kotli.app.AppNavigationRouter
import kotli.app.AppState
import org.koin.dsl.module

val ProvidesAppState = module {
    single { AppState() }
    single { AppNavigationRouter() }
}