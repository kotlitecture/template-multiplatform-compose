package kotli.app.auth.signin.email

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotli.app.auth.otp.presentation.OtpScreen
import kotli.app.auth.signin.email.domain.usecase.SignInWithEmailUseCase
import kotli.app.auth.signin.email.domain.usecase.VerifyEmailUseCase
import kotli.app.auth.signin.email.presentation.SignInWithEmailRoute
import kotli.app.auth.signin.email.presentation.SignInWithEmailScreen
import kotli.app.auth.signin.email.presentation.SignInWithEmailViewModel
import kotli.app.get
import org.jetbrains.compose.resources.stringResource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import shared.presentation.navigation.back
import shared.presentation.navigation.replacePrevious
import template.app.generated.resources.Res
import template.app.generated.resources.auth_sign_in_email_verify_title

fun NavGraphBuilder.signInWithEmail(navController: NavHostController) {
    composable<SignInWithEmailRoute.Start> {
        SignInWithEmailScreen(
            onVerify = { email ->
                val route = SignInWithEmailRoute.Verify(email)
                navController.replacePrevious(route)
            },
            onBack = navController::back,
        )
    }

    composable<SignInWithEmailRoute.Verify> {
        val route = it.toRoute<SignInWithEmailRoute.Verify>()
        OtpScreen(
            title = stringResource(Res.string.auth_sign_in_email_verify_title),
            subTitle = route.email,
            onBack = navController::back,
            onSuccess = navController::back,
            onVerify = { otp ->
                val verifyUseCase = get<VerifyEmailUseCase>()
                verifyUseCase.invoke(route.email, otp)
            },
            onResend = {
                val resendUseCase = get<SignInWithEmailUseCase>()
                resendUseCase.invoke(route.email)
            }
        )
    }
}

fun InitializerViewModelFactoryBuilder.signInWithEmail() {
    initializer { SignInWithEmailViewModel(get()) }
}

val signInWithEmail = module {
    factoryOf(::SignInWithEmailUseCase)
    factoryOf(::VerifyEmailUseCase)
}