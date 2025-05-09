package kotli.app.theme

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotli.app.get
import kotli.app.theme.change.presentation.ChangeThemeBottomSheet
import kotli.app.theme.change.presentation.ChangeThemeBottomSheetRoute
import kotli.app.theme.change.presentation.ChangeThemeDialog
import kotli.app.theme.change.presentation.ChangeThemeDialogRoute
import kotli.app.theme.change.presentation.ChangeThemeRoute
import kotli.app.theme.change.presentation.ChangeThemeScreen
import kotli.app.theme.change.presentation.ChangeThemeViewModel
import kotli.app.theme.provide.data.ThemeRepositoryImpl
import kotli.app.theme.provide.domain.repository.ThemeRepository
import kotli.app.theme.provide.domain.usecase.RestoreThemeUseCase
import kotli.app.theme.provide.domain.usecase.StoreThemeUseCase
import kotli.app.theme.provide.presentation.ThemeStatefulViewModel
import kotli.app.theme.provide.presentation.ThemeStatelessViewModel
import kotli.app.theme.toggle.presentation.ToggleThemeViewModel
import org.koin.dsl.module
import shared.presentation.navigation.back
import shared.presentation.theme.DefaultThemeState
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeState
import shared.presentation.ui.theme.DsThemes

fun NavGraphBuilder.theme(navController: NavHostController) {
    dialog<ChangeThemeBottomSheetRoute> { ChangeThemeBottomSheet(navController::back) }
    composable<ChangeThemeRoute> { ChangeThemeScreen(navController::back) }
    dialog<ChangeThemeDialogRoute> { ChangeThemeDialog() }
}

fun InitializerViewModelFactoryBuilder.theme() {
    initializer { ThemeStatelessViewModel(get()) }
    initializer { ThemeStatefulViewModel(get(), get(), get()) }
    initializer { ChangeThemeViewModel(get()) }
    initializer { ToggleThemeViewModel(get()) }
}

val theme = module {
    single<ThemeState> {
        DefaultThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = DsThemes.Light,
                lightTheme = DsThemes.Light,
                darkTheme = DsThemes.Dark,
            )
        )
    }
    single<ThemeRepository> { ThemeRepositoryImpl(get()) }
    factory { StoreThemeUseCase(get()) }
    factory { RestoreThemeUseCase(get()) }
}