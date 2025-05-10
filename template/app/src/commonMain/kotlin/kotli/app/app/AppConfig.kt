package kotli.app.app

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.app.presentation.AppMutableState
import kotli.app.app.presentation.AppState
import kotli.app.app.presentation.AppViewModel
import kotli.app.auth.auth
import kotli.app.common.common
import kotli.app.get
import kotli.app.home.home
import kotli.app.navigation.navigation
import kotli.app.passcode.passcode
import kotli.app.platform.platform
import kotli.app.profile.profile
import kotli.app.showcases.showcases
import kotli.app.template.feature.template
import kotli.app.theme.theme
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.presentation.ui.component.DsSnackbarState

fun NavGraphBuilder.app(navController: NavHostController) {
    platform(navController)
    auth(navController)
    common(navController)
    home(navController)
    navigation(navController)
    passcode(navController)
    profile(navController)
    showcases(navController)
    template(navController)
    theme(navController)
}

fun InitializerViewModelFactoryBuilder.app() {
    initializer { AppViewModel(get()) }
    platform()
    auth()
    common()
    home()
    navigation()
    passcode()
    profile()
    showcases()
    template()
    theme()
}

val app = module {
    single { DsSnackbarState() }
    single { AppMutableState(get()) }.bind(AppState::class)
    includes(
        platform,
        auth,
        common,
        home,
        navigation,
        passcode,
        profile,
        showcases,
        template,
        theme,
    )
}