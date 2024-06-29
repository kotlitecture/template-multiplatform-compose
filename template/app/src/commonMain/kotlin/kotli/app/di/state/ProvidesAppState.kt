package kotli.app.di.state

import kotli.app.AppNavigationRouter
import kotli.app.AppStore
import org.koin.dsl.module
import shared.design.component.AppSnackbarStore

val ProvidesAppState = module {
    single { AppStore() }
    single { AppSnackbarStore() }
    single { AppNavigationRouter() }
}