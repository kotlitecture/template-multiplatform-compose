package kotli.app.auth.signin.google

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.auth.signin.google.domain.usecase.SignInWithGoogleUseCase
import kotli.app.auth.signin.google.presentation.SignInWithGoogleViewModel
import kotli.app.auth.signin.google.presentation.flow.GoogleFlowProvider
import kotli.app.auth.signin.google.presentation.flow.StubFlowProvider
import kotli.app.auth.signin.google.presentation.flow.SupabaseFlowProvider
import kotli.app.get
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun NavGraphBuilder.signInWithGoogle(navController: NavHostController) {}

fun InitializerViewModelFactoryBuilder.signInWithGoogle() {
    initializer { SignInWithGoogleViewModel(get()) }
}

val signInWithGoogle = module {
    factoryOf(::SupabaseFlowProvider).bind<GoogleFlowProvider>()
    factoryOf(::StubFlowProvider).bind<GoogleFlowProvider>()
    factoryOf(::SignInWithGoogleUseCase)
}