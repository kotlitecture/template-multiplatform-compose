package kotli.app.di.feature

import kotli.app.AppMutableState
import kotli.app.AppState
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.design.component.AppSnackbarState

val appModule = module {
    single { AppSnackbarState() }
    single { AppMutableState(get()) }.bind(AppState::class)
}