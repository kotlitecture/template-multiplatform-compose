package kotli.app.auth.common

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.auth.common.data.repository.StubAuthRepository
import kotli.app.auth.common.data.repository.SupabaseAuthRepository
import kotli.app.auth.common.domain.repository.AuthRepository
import kotli.app.auth.common.domain.usecase.GetAuthUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun NavGraphBuilder.common(navController: NavHostController) {}

fun InitializerViewModelFactoryBuilder.common() {}

val authCommon = module {
    singleOf(::StubAuthRepository).bind<AuthRepository>()
    singleOf(::SupabaseAuthRepository).bind<AuthRepository>()
    factoryOf(::GetAuthUseCase)
}