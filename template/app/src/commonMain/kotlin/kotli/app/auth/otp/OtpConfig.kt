package kotli.app.auth.otp

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.auth.otp.presentation.OtpViewModel
import org.koin.dsl.module

fun NavGraphBuilder.otp(navController: NavHostController) {}

fun InitializerViewModelFactoryBuilder.otp() {
    initializer { OtpViewModel() }
}

val otp = module {}
