package kotli.app

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.common.common
import kotli.app.di.inject
import kotli.app.feature.navigation.navigation
import kotli.app.feature.passcode.passcode
import kotli.app.feature.showcases.showcases
import kotli.app.feature.theme.theme

interface AppRoute

fun NavGraphBuilder.app(navController: NavHostController) {
    theme(navController)
    passcode(navController)
    showcases(navController)
    navigation(navController)
}

fun InitializerViewModelFactoryBuilder.app() {
    initializer { AppViewModel(inject()) }
    common()
    theme()
    passcode()
    showcases()
    navigation()
}