package kotli.app.app

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.common.common
import kotli.app.get
import kotli.app.home.home
import kotli.app.navigation.navigation
import kotli.app.passcode.passcode
import kotli.app.platform.platform
import kotli.app.showcases.showcases
import kotli.app.theme.theme
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.design.component.AppSnackbarState

fun NavGraphBuilder.app(navController: NavHostController) {
    common(navController)
    home(navController)
    theme(navController)
    passcode(navController)
    showcases(navController)
    navigation(navController)
    platform(navController)
}

fun InitializerViewModelFactoryBuilder.app() {
    initializer { AppViewModel(get()) }
    common()
    home()
    theme()
    passcode()
    showcases()
    navigation()
    platform()
}

val app = module {
    single { AppSnackbarState() }
    single { AppMutableState(get()) }.bind(AppState::class)
    includes(
        common,
        home,
        theme,
        passcode,
        showcases,
        navigation,
        platform,
    )
}