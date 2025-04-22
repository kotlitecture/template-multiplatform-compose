package kotli.app.auth.userflow

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotli.app.auth.signin.email.presentation.SignInWithEmailRoute
import kotli.app.auth.signout.presentation.SignOutRoute
import kotli.app.auth.userflow.presentation.basic.BasicAuthRoute
import kotli.app.auth.userflow.presentation.basic.BasicAuthScreen
import kotli.app.auth.userflow.presentation.basic.BasicAuthViewModel
import kotli.app.get
import org.koin.dsl.module
import shared.presentation.navigation.back
import shared.presentation.navigation.newInstance

fun NavGraphBuilder.userFlow(navController: NavHostController) {
    composable<BasicAuthRoute> {
        val route = it.toRoute<BasicAuthRoute>()

        BasicAuthScreen(
            title = route.title,
            onBack = navController::back,
            onSignOut = { navController.newInstance(SignOutRoute) },
            onSignInWithEmail = { navController.newInstance(SignInWithEmailRoute.Start) }
        )
    }
}

fun InitializerViewModelFactoryBuilder.userFlow() {
    initializer { BasicAuthViewModel(get()) }
}

val userFlow = module {

}