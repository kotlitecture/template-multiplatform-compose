package kotli.app.auth.signout

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import kotli.app.auth.signout.domain.usecase.SignOutUseCase
import kotli.app.auth.signout.presentation.SignOutRoute
import kotli.app.auth.signout.presentation.SignOutDialog
import kotli.app.auth.signout.presentation.SignOutViewModel
import kotli.app.get
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import shared.presentation.navigation.back

fun NavGraphBuilder.signOut(navController: NavHostController) {
    dialog<SignOutRoute> {
        SignOutDialog(
            onCancel = navController::back,
            onSuccess = navController::back
        )
    }
}

fun InitializerViewModelFactoryBuilder.signOut() {
    initializer { SignOutViewModel(get()) }
}

val signOut = module {
    factoryOf(::SignOutUseCase)
}