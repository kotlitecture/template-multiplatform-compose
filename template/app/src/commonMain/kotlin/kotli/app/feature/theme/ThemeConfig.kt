package kotli.app.feature.theme

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotli.app.feature.theme.change.presentation.ChangeThemeDialog
import kotli.app.feature.theme.change.presentation.ChangeThemeDialogRoute
import kotli.app.feature.theme.change.presentation.ChangeThemeRoute
import kotli.app.feature.theme.change.presentation.ChangeThemeScreen
import kotli.app.feature.theme.change.presentation.ChangeThemeViewModel
import kotli.app.feature.theme.provide.presentation.ThemeStatefulViewModel
import kotli.app.feature.theme.provide.presentation.ThemeStatelessViewModel
import kotli.app.feature.theme.toggle.presentation.ToggleThemeViewModel
import kotli.app.di.inject
import shared.presentation.misc.back

fun NavGraphBuilder.theme(navController: NavHostController) {
    composable<ChangeThemeRoute> { ChangeThemeScreen(navController::back) }
    dialog<ChangeThemeDialogRoute> { ChangeThemeDialog() }
}

fun InitializerViewModelFactoryBuilder.theme() {
    initializer { ThemeStatelessViewModel(inject()) }
    initializer { ThemeStatefulViewModel(inject(), inject(), inject()) }
    initializer { ChangeThemeViewModel(inject()) }
    initializer { ToggleThemeViewModel(inject()) }
}