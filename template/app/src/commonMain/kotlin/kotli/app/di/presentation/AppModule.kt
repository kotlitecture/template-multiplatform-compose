package kotli.app.di.presentation

import kotli.app.AppNavigationRouter
import kotli.app.AppStore
import org.koin.dsl.module
import shared.design.component.AppSnackbarStore

val appModule = module {
    single { AppStore() }
    single { AppSnackbarStore() }
    single { AppNavigationRouter() }
}