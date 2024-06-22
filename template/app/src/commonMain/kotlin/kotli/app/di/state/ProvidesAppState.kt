package kotli.app.di.state

import kotli.app.AppNavigationRouter
import kotli.app.AppState
import org.koin.dsl.module
import shared.design.component.AppSnackbarState

val ProvidesAppState = module {
    single { AppState() }
    single { AppSnackbarState() }
    single { AppNavigationRouter() }
}